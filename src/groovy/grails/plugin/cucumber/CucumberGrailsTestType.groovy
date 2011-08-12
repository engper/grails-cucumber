/*
 * Copyright 2011 Martin Hauner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package grails.plugin.cucumber

import org.codehaus.groovy.grails.test.GrailsTestTypeResult
import org.codehaus.groovy.grails.test.event.GrailsTestEventPublisher
import org.codehaus.groovy.grails.test.support.GrailsTestTypeSupport


class CucumberGrailsTestType extends GrailsTestTypeSupport {
    static final NAME = "cucumber"
    String pluginHome

    CucumberGrailsTestType (String pluginHome) {
        super (NAME, NAME)
        this.pluginHome = pluginHome
    }
    
    void setup () {
        def jrubyHome = new Folder (
            new File ([pluginHome, "lib", ".jruby"].join (File.separator)))

        def installer = new Cuke4DukeInstaller (jrubyHome, new JGem ())
        def setup = new Cuke4DukeSetup (jrubyHome, installer)
        setup.run ()
    }

    @Override
    int doPrepare () {
        // todo
        return 1
    }

    @Override
    GrailsTestTypeResult doRun (GrailsTestEventPublisher eventPublisher) {
        //eventPublisher.testCaseStart('*** Cucumber Test Case Start ***')
        //eventPublisher.testStart('** Cucumber Test Start **')
        //eventPublisher.testEnd('** Cucumber Test End **')
        //eventPublisher.testCaseEnd('*** Cucumber Test Case End ***')
        return new CucumberGrailsTestTypeResult ()
    }
}