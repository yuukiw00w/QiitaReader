# QiitaReader
## アプリ概要

Qiitaの記事一覧を取得して表示し、記事を選択して記事詳細画面に遷移するアプリ

## 設計方針

基本的には[Google推奨のアーキテクチャ](https://developer.android.com/jetpack/docs/guide?hl=ja)を採用。

## 機能と表示内容詳細

ローディングやエラー処理などは未実施。

単純にonCreateでAPIを叩き、取得できたらカード形式で記事一覧を表示する。

記事一覧は更新日時、タイトル、中身のテキストを表示、詳細の方はタイトルと中身のテキストを表示する。

## 対応した項目について

AndroidXやNavigationを使った遷移
Data Binding
マルチモジュール化

## セットアップ手順

特に特別な手順は不要

Downloadしたあとそのままビルド、実行が可能
