package plugin

import com.android.build.api.dsl.ApplicationExtension
import composite.configureVariants
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidVariantsConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<ApplicationExtension> {
                configureVariants(this)
            }
        }
    }
}
