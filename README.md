# Awesome Journal

Android用のジャーナルアプリ「**Awesome Journal**」開発用リポジトリ。

## 環境

- Android Studio Flamingo | 2022.2.1 Patch 2 or later
- JDK 17

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
