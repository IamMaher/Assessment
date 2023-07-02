package plugin

import composite.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidKotlinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
            }

            configureKotlin()
        }
    }
}
