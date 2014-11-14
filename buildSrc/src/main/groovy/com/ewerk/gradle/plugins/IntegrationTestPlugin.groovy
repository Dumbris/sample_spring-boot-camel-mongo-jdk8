/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ewerk.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test

class IntegrationTestPlugin implements Plugin<Project> {
  @Override
  void apply(final Project project) {

    project.sourceSets {
      integration {
        java.srcDir project.file('src/integration/java')
        resources.srcDir project.file('src/integration/resources')
      }
    }

    project.dependencies {
      integrationCompile project.configurations.testCompile
      integrationRuntime project.configurations.testRuntime

      integrationCompile project.sourceSets.main.output
      integrationCompile project.sourceSets.test.output
    }

    project.task('integrationTest', type: Test, description: 'Runs the integration tests.',
        group: 'Verification') {
      testClassesDir = project.sourceSets.integration.output.classesDir
      classpath = project.sourceSets.integration.runtimeClasspath
    }

    project.task('allTests', dependsOn: [project.test, project.integrationTest],
        description: 'Runs all tests.', group: 'Verification') {
    }
  }
}