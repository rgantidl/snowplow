/*
 * Copyright (c) 2014 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
import sbt._

object Dependencies {

  val resolutionRepos = Seq(
    // For some misc Scalding and Twitter libs
    "Concurrent Maven Repo" at "http://conjars.org/repo",
    "Clojars Maven Repo" at "http://clojars.org/repo",
    // For Twitter libs
    "Twitter maven libs" at "http://maven.twttr.com/",
    // For Snowplow libs
    "Snowplow Analytics Maven repo" at "http://maven.snplow.com/releases/",
    "Snowplow Analytics Maven snapshot repo" at "http://maven.snplow.com/snapshots/",
    "user-agent-utils repo" at "https://raw.github.com/HaraldWalker/user-agent-utils/mvn-repo/",

    "Conjars" at "http://conjars.org/repo"
  )
  object V {
    // Java
    val hadoop              = "2.4.1"
    val cascading           = "2.6.0"
    val elasticsearchHadoop = "2.1.0"
    // Scala
    val scalding            = "0.11.2"
    val scaldingEs          = "0.6_scalding0.10"
    val scalaz7             = "7.0.0"
    val commonEnrich        = "0.18.0"
    // Scala (test only)
    val specs2              = "1.14"
    val scalazSpecs2        = "0.1.2"
  }

  // The scalding-taps and elasticsearch-hadoop dependencies are marked intransitive to prevent dependency hell.
  // Changing these dependencies could introduce an incompatibility that isn't noticed until runtime.
  object Libraries {
    // Java
    val hadoopCommon        = "org.apache.hadoop"         %  "hadoop-common"                % V.hadoop       % "provided"
    val hadoopClientCore    = "org.apache.hadoop"         %  "hadoop-mapreduce-client-core" % V.hadoop       % "provided"
    val cascadingCore       = "cascading"                 %  "cascading-core"               % V.cascading
    val cascadingLocal      = "cascading"                 %  "cascading-local"              % V.cascading
    val cascadingHadoop     = "cascading"                 %  "cascading-hadoop2-mr1"        % V.cascading
    val elasticsearchHadoop = "org.elasticsearch"         %  "elasticsearch-hadoop"         % V.elasticsearchHadoop intransitive()
    // Scala
    val scaldingCore        = "com.twitter"               %% "scalding-core"                % V.scalding exclude( "cascading", "cascading-local" ) exclude( "cascading", "cascading-hadoop" )
    val scaldingArgs        = "com.twitter"               %% "scalding-args"                % V.scalding exclude( "cascading", "cascading-local" ) exclude( "cascading", "cascading-hadoop" )
    val scaldingCommons     = "com.twitter"               %% "scalding-commons"             % V.scalding exclude( "cascading", "cascading-local" ) exclude( "cascading", "cascading-hadoop" )
    val scaldingJson        = "com.twitter"               %% "scalding-json"                % V.scalding exclude( "cascading", "cascading-local" ) exclude( "cascading", "cascading-hadoop" )
    val scaldingEs          = "io.scalding"               %% "scalding-taps"                % V.scaldingEs intransitive()
    val scalaz7             = "org.scalaz"                %% "scalaz-core"                  % V.scalaz7
    val commonEnrich        = "com.snowplowanalytics"     %  "snowplow-common-enrich"       % V.commonEnrich
    // Scala (test only)
    val specs2              = "org.specs2"                %% "specs2"                       % V.specs2       % "test"
    val scalazSpecs2        = "org.typelevel"             %% "scalaz-specs2"                % V.scalazSpecs2 % "test"
  }
}
