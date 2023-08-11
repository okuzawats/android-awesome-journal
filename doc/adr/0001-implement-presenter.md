# 1. implement Presenter

Date: 2023-08-11

## Status

Accepted

## Context

UI（Compose）の状態管理を最低限のシンプルな構成で実装したい。

[Circuit](https://slackhq.github.io/circuit/)に見られるような、PresenterがStateをpresentする構成は、ミニマムかつ単一方向のデータフローを実現している。

しかしながら、CircuitはUIの状態管理以外の責務も持ち、それなりに大きなライブラリである。UIの状態管理のためだけにCircuitを導入するのは、今後のメンテナンスコストが必要以上に大きくなってしまう。 また、UIの状態管理がCircuitにロックインされてしまって好ましくない。

Presenterのinterfaceを独自に定義し、Circuitの提唱するようなPresenterを導入する。

## Decision

Circuitによらず、同等のPresenterを定義する。

## Consequences

Presenterの実装についてのルールができるため、UIの状態管理の実装に悩まず、認知負荷の低いコードベースを提供することができる。
