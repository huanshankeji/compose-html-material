# Contributing guidelines

Hello, thank you for your interest in contributing to our project.

## Issues and Discussions

You are welcome to submit issues on bugs or feature requests. If you have questions, please ask them in GitHub Discussions.

## Pull requests

If you want to contribute to the code of our project, you are welcome to open pull requests. However, it's always a good idea to open a related issue or talk with us in Discussions first.

## Development

Please make sure you have a valid JDK installed. Some projects may require multiple JDKs of different versions. The JDK version we use can be found in the [GitHub Actions workflow files](.github/workflows).

We recommend developing with IntelliJ IDEA. In IntelliJ IDEA, select the correct [Project SDK in Project Structure](https://www.jetbrains.com/help/idea/project-settings-and-structure.html#project-sdk) and it's recommended to set [Gradle JVM](https://www.jetbrains.com/help/idea/gradle-jvm-selection.html#jvm_settings) to "Project SDK".

Run the `publishToMavenLocal` Gradle task to publish the libraries to your machine's Maven Local Repository so your projects can depend on the changes you have made, run `check` to ensure our limited number of tests pass.

Resolving **dev-commit** Huanshankeji artifacts from [GitHub Packages](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry) (Gradle plugins from `gradle-common`, and any sibling dependency libraries configured in `settings.gradle.kts`) requires authentication. Put a [personal access token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens) with the `read:packages` scope in `~/.gradle/gradle.properties`:

```properties
gpr.user=<GitHub username>
gpr.key=<PAT with read:packages>
```

Credentials are not needed for artifacts already present in Maven local (for example after `./gradlew publishToMavenLocal` in upstream repos).

**Note:** The `compose-html-material-legacy` module is no longer maintained. Please do not submit pull requests or make changes to this module. Focus contributions on `compose-html-material3` and `compose-html-common` modules.

## Further notice

We are currently a small team with limited effort. While we may not always implement your requested features, merge your pull requests, or do such things in time, you are always welcome to create your own fork and make any changes you like.
