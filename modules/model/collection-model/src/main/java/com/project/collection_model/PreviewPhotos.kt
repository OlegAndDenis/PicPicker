package com.project.collection_model

import com.google.gson.annotations.SerializedName

data class PreviewPhotos(
	@SerializedName("id") val id: String,
	@SerializedName("created_at") val createdAt: String,
	@SerializedName("updated_at") val updatedAt: String,
	@SerializedName("blur_hash") val blurHash: String,
	@SerializedName("urls") val urls: Urls,
)

fun List<PreviewPhotos>.smallPhoto(index: Int): String {
    return getOrNull(index)?.urls?.small.orEmpty()
}

fun List<PreviewPhotos>.thumbPhoto(index: Int): String {
    return getOrNull(index)?.urls?.thumb.orEmpty()
}