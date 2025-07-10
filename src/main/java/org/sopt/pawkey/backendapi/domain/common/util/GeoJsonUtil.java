package org.sopt.pawkey.backendapi.domain.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

public class GeoJsonUtil {
	public static Map<String, Object> toGeoJson(Geometry geometry) {
		if (geometry instanceof MultiPolygon) {
			return multiPolygonToGeoJson((MultiPolygon) geometry);
		} else if (geometry instanceof Polygon) {
			return polygonToGeoJson((Polygon) geometry);
		} else if (geometry instanceof LineString) {
			return lineStringToGeoJson((LineString) geometry);
		} else if (geometry instanceof Point) {
			return pointToGeoJson((Point) geometry);
		} else {
			throw new IllegalArgumentException("Unsupported geometry type: " + geometry.getGeometryType());
		}
	}

	private static Map<String, Object> multiPolygonToGeoJson(MultiPolygon multiPolygon) {
		List<List<List<List<Double>>>> coordinates = new ArrayList<>();
		for (int i = 0; i < multiPolygon.getNumGeometries(); i++) {
			Polygon polygon = (Polygon) multiPolygon.getGeometryN(i);
			coordinates.add(extractPolygonCoordinates(polygon));
		}
		Map<String, Object> geoJson = new LinkedHashMap<>();
		geoJson.put("type", "MultiPolygon");
		geoJson.put("coordinates", coordinates);
		return geoJson;
	}

	private static Map<String, Object> polygonToGeoJson(Polygon polygon) {
		List<List<List<Double>>> coordinates = extractPolygonCoordinates(polygon);
		Map<String, Object> geoJson = new LinkedHashMap<>();
		geoJson.put("type", "Polygon");
		geoJson.put("coordinates", coordinates);
		return geoJson;
	}

	private static List<List<List<Double>>> extractPolygonCoordinates(Polygon polygon) {
		List<List<List<Double>>> polygonCoordinates = new ArrayList<>();

		// exterior ring
		polygonCoordinates.add(extractLineStringCoordinates(polygon.getExteriorRing()));

		// interior rings (holes)
		for (int j = 0; j < polygon.getNumInteriorRing(); j++) {
			polygonCoordinates.add(extractLineStringCoordinates(polygon.getInteriorRingN(j)));
		}

		return polygonCoordinates;
	}

	private static Map<String, Object> lineStringToGeoJson(LineString line) {
		List<List<Double>> coordinates = extractLineStringCoordinates(line);
		Map<String, Object> geoJson = new LinkedHashMap<>();
		geoJson.put("type", "LineString");
		geoJson.put("coordinates", coordinates);
		return geoJson;
	}

	private static List<List<Double>> extractLineStringCoordinates(LineString line) {
		List<List<Double>> coordinates = new ArrayList<>();
		for (Coordinate coord : line.getCoordinates()) {
			coordinates.add(Arrays.asList(coord.x, coord.y));
		}
		return coordinates;
	}

	private static Map<String, Object> pointToGeoJson(Point point) {
		Map<String, Object> geoJson = new LinkedHashMap<>();
		geoJson.put("type", "Point");
		geoJson.put("coordinates", Arrays.asList(point.getX(), point.getY()));
		return geoJson;
	}
}
