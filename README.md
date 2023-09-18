# Awesome Journal

[![codecov](https://codecov.io/gh/okuzawats/android-awesome-journal/graph/badge.svg?token=B3SOKT47SC)](https://codecov.io/gh/okuzawats/android-awesome-journal)

Android用のジャーナルアプリ「**Awesome Journal**」開発用リポジトリ。

## 環境

- Android Studio Giraffe | 2022.3.1 or later
- JDK 17

## カバレッジ

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
