package composite

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project

fun Project.configureAndroidLibrary(
    extension: LibraryExtension,
) {
    extension.apply {
        defaultConfig {
            targetSdk = 33
        }
    }
}