/*
 * Copyright 2007-2008 WorldWide Conferencing, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package net.liftweb.builtin.snippet

import net.liftweb.http._
import scala.xml._

class CSS {
  def blueprint: NodeSeq = {
    <xml:group>
    <link rel="stylesheet" href="/classpath/blueprint/screen.css" type="text/css" media="screen, projection"/>
    <link rel="stylesheet" href="/classpath/blueprint/print.css" type="text/css" media="print"/>
    </xml:group>  ++
    Unparsed("""
  <!--[if IE]><link rel="stylesheet" href="""+'"'+S.contextPath+"""/classpath/blueprint/lib/ie.css" type="text/css" media="screen, projection"><![endif]-->
    """)
  }

  def fancyType: NodeSeq = {
    <link rel="stylesheet" href="/classpath/blueprint/plugins/fancy-type/fancy-type.css" type="text/css" media="screen, projection"/>
  }
}
