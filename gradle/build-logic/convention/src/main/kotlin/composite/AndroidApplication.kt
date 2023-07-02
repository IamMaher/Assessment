package composite

import com.android.build.api.dsl.ApplicationExtension
import Versions
import org.gradle.api.Project

fun Project.configureAndroidApplication(android: ApplicationExtension) {

    android.apply {
        defaultConfig {
            targetSdk = Versions.targetSdk
        }
    }
}