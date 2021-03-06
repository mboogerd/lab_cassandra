logLevel := Level.Warn

resolvers ++= Seq(
  Resolver.url("scoverag,e-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns),
  "jgit-repo" at "http://download.eclipse.org/jgit/maven"
)

addSbtPlugin("org.scalastyle"       %% "scalastyle-sbt-plugin"  % "0.8.0")
addSbtPlugin("org.scoverage"        % "sbt-scoverage"           % "1.3.5")
addSbtPlugin("de.heikoseeberger"    % "sbt-header"              % "1.5.1")
addSbtPlugin("org.tpolecat"         % "tut-plugin"              % "0.4.3")
addSbtPlugin("com.eed3si9n"         % "sbt-unidoc"              % "0.3.3")
addSbtPlugin("com.github.tkawachi"  % "sbt-doctest"             % "0.3.5")
addSbtPlugin("com.typesafe.sbt"     % "sbt-site"                % "1.0.0")
addSbtPlugin("com.typesafe.sbt"     % "sbt-ghpages"             % "0.5.4")
addSbtPlugin("com.timushev.sbt"     % "sbt-updates"             % "0.1.10")
addSbtPlugin("org.xerial.sbt"       % "sbt-sonatype"            % "1.1")
addSbtPlugin("com.jsuereth"         % "sbt-pgp"                 % "1.0.0")
addSbtPlugin("com.github.gseitz"    % "sbt-release"             % "1.0.3")


// FROM: http://outworkers.com/blog/post/phantom-tips-tip2-testing-with-phantom-sbt
// This will allow you to download the plugin directly from Maven Central.
// It's simply instructing SBT what path to use to retrieve it from there.
def outworkersPattern: Patterns = {
  val pattern = "[organisation]/[module](_[scalaVersion])(_[sbtVersion])/[revision]/[artifact]-[revision](-[classifier]).[ext]"

  Patterns(
    pattern :: Nil,
    pattern :: Nil,
    isMavenCompatible = true
  )
}

resolvers ++= Seq(
  // whatever is already in here..,
  Resolver.bintrayRepo("websudos", "oss-releases"),
  Resolver.url(
    "Maven Ivy Websudos",
    url(Resolver.DefaultMavenRepositoryRoot)
  )(outworkersPattern),
  Resolver.url(
    "Outworkers OSS",
    url("http://dl.bintray.com/websudos/oss-releases")
  )(Resolver.ivyStylePatterns)
)

// And finally the plugin dependency itself
addSbtPlugin("com.websudos" %% "phantom-sbt" % "1.27.0")