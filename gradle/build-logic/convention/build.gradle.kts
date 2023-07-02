plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {

        register("androidApplication") {
            id = "composite.android.application"
            implementationClass = "plugin.AndroidApplicationConventionPlugin"
        }
        register("androidKotlin") {
            id = "composite.jetbrains.kotlin.android"
            implementationClass = "plugin.AndroidKotlinConventionPlugin"
        }
        register("androidVariants") {
            id = "composite.android.variants"
            implementationClass = "plugin.AndroidVariantsConventionPlugin"
        }
        register("androidLibrary") {
            id = "composite.android.library"
            implementationClass = "plugin.AndroidLibraryConventionPlugin"
        }
        register("androidCompose") {
            id = "composite.android.compose"
            implementationClass = "plugin.AndroidComposeConventionPlugin"
        }
    }
}
