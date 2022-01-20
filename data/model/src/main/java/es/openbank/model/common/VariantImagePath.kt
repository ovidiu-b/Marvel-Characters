package es.openbank.model.common

enum class PortraitVariantImagePath(val value: String) {
    SMALL("portrait_small"), // 50x75px
    MEDIUM("portrait_medium"), // 100x150px
    XLARGE("portrait_xlarge"), // 150x225px
    FANTASTIC("portrait_fantastic"), // 168x252px
    UNCANNY("portrait_uncanny"), // 300x450px
    INCREDIBLE("portrait_incredible") // 216x324px
}

enum class StandardVariantImagePath(val value: String) {
    SMALL("standard_small"), // 65x45px
    MEDIUM("standard_medium"), // 100x100px
    LARGE("standard_large"), // 140x140px
    XLARGE("standard_xlarge"), // 200x200px
    FANTASTIC("standard_fantastic"), // 250x250px
    AMAZING("standard_amazing") // 180x180px
}

enum class LandscapeVariantImagePath(val value: String) {
    SMALL("landscape_small"), // 120x90px
    MEDIUM("landscape_medium"), // 175x130px
    LARGE("landscape_large"), // 190x140px
    XLARGE("landscape_xlarge"), // 270x200px
    AMAZING("landscape_amazing"), // 250x156px
    INCREDIBLE("landscape_incredible") // 464x261px
}