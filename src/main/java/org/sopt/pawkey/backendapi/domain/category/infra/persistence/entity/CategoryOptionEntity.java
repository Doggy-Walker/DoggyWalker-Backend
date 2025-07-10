package org.sopt.pawkey.backendapi.domain.category.infra.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostCategoryOptionTop3Entity;
import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostSelectedCategoryOptionEntity;
import org.sopt.pawkey.backendapi.domain.review.infra.persistence.entity.ReviewSelectedCategoryOptionEntity;
import org.sopt.pawkey.backendapi.global.infra.persistence.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category_option")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
public class CategoryOptionEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_option_id")
	private Long id;

	@Column(name = "option_text", nullable = false)
	private String optionText;

	@Column(name = "option_text_summary", nullable = false)
	private String optionTextSummary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryEntity category;

	@OneToMany(mappedBy = "categoryOption", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PostSelectedCategoryOptionEntity> postSelectedCategoryOptionEntityList = new ArrayList<>();

	@OneToMany(mappedBy = "categoryOption", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ReviewSelectedCategoryOptionEntity> reviewSelectedCategoryOptionEntityList = new ArrayList<>();

	@OneToMany(mappedBy = "categoryOption", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PostCategoryOptionTop3Entity> postCategoryOptionTop3EntityList = new ArrayList<>();
}
