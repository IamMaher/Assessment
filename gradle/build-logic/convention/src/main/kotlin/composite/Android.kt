package composite

import com.android.build.api.dsl.CommonExtension
import Versions
import org.gradle.api.Project

fun Project.configureAndroid(android: CommonExtension<*,*,*,*,*>) {

    android.apply {
        compileSdk = Versions.compileSdk

        defaultConfig {
            minSdk = Versions.minSdk
            vectorDrawables {
                useSupportLibrary = true
            }
        }

        buildFeatures.buildConfig = true

        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }
}