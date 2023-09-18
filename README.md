# Awesome Journal

[![codecov](https://codecov.io/gh/okuzawats/android-awesome-journal/graph/badge.svg?token=B3SOKT47SC)](https://codecov.io/gh/okuzawats/android-awesome-journal)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=okuzawats_android-awesome-journal&metric=sqale_rating&token=0e14173fc44a164c8a24c5db7c9697324becc036)](https://sonarcloud.io/summary/new_code?id=okuzawats_android-awesome-journal)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=okuzawats_android-awesome-journal&metric=code_smells&token=0e14173fc44a164c8a24c5db7c9697324becc036)](https://sonarcloud.io/summary/new_code?id=okuzawats_android-awesome-journal)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=okuzawats_android-awesome-journal&metric=ncloc&token=0e14173fc44a164c8a24c5db7c9697324becc036)](https://sonarcloud.io/summary/new_code?id=okuzawats_android-awesome-journal)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=okuzawats_android-awesome-journal&metric=coverage&token=0e14173fc44a164c8a24c5db7c9697324becc036)](https://sonarcloud.io/summary/new_code?id=okuzawats_android-awesome-journal)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=okuzawats_android-awesome-journal&metric=sqale_index&token=0e14173fc44a164c8a24c5db7c9697324becc036)](https://sonarcloud.io/summary/new_code?id=okuzawats_android-awesome-journal)

Android用のジャーナルアプリ「**Awesome Journal**」開発用リポジトリ。

## 環境

- Android Studio Giraffe | 2022.3.1 or later
- JDK 17

## Continuous Inspection

[SonarCloud](https://sonarcloud.io/project/overview?id=okuzawats_android-awesome-journal)

[Codecov](https://app.codecov.io/gh/okuzawats/android-awesome-journal)

## ADR

[npryce/adr-tools](https://github.com/npryce/adr-tools)を用いて、CLIによりADR（Architecture Decision Records）を作成・更新する。

Homebrewを用いて `adr-tools` をインストールする。

```console
$ brew install adr-tools
```

ADRを作成する。

```console
$ adr new Implement as Unix shell scripts
```

ヘルプを表示する。

```console
$ adr help
```
