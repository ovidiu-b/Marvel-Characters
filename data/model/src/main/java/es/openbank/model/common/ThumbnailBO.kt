package es.openbank.model.common

data class ThumbnailBO (val path: String, val extension: String) {

    fun getUrlVariant(variant: PortraitVariantImagePath): String {
        return buildUrlVariant(variant.value)
    }

    fun getUrlVariant(variant: StandardVariantImagePath): String {
        return buildUrlVariant(variant.value)
    }

    fun getUrlVariant(variant: LandscapeVariantImagePath): String {
        return buildUrlVariant(variant.value)
    }

    private fun buildUrlVariant(variantValue: String): String {
        return "$path/${variantValue}.$extension"
    }

}