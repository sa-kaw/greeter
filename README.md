# Greeter

これは maven central にライブラリを公開する方法のサンプルプロジェクトです。
ここではリポジトリの管理や maven central のネームスペース取得のために GitHub を使用します。
また、公開作業には jreleaser を使用します。

## やること

1. Gradle でライブラリのプロジェクトを用意する
2. 証明用に GPG で鍵を用意する
3. GitHub のアカウントを用意する
4. GitHub のユーザートークンを生成する
5. maven central のアカウントを GitHub アカウントを使って用意する(https://central.sonatype.com/)
6. maven central のユーザートークンを生成する(https://central.sonatype.com/account)
7. `{user}/.jreleaser/config.toml`を用意する
8. build.gradle で`maven-publish`プラグインを使って Maven Repository にパッケージを生成できるようにする
9. build.gradle で`org.jreleaser`プラグインを使って Maven Central に公開できるようにする
10. build.gradle で`org.jreleaser`プラグインを使って GitHub でリリースを作れるようにする

```toml
JRELEASER_GITHUB_TOKEN = "<your github token>"

JRELEASER_MAVENCENTRAL_USERNAME = "<your username of maven central user token>"
JRELEASER_MAVENCENTRAL_PASSWORD = "<your password of maven central user token>"

JRELEASER_GPG_PASSPHRASE = "<your secret key passphrase>"
JRELEASER_GPG_PUBLIC_KEY = """-----BEGIN PGP PUBLIC KEY BLOCK-----

<your public key>

-----END PGP PUBLIC KEY BLOCK-----"""

JRELEASER_GPG_SECRET_KEY = """-----BEGIN PGP PRIVATE KEY BLOCK-----

<your private key>

-----END PGP PRIVATE KEY BLOCK-----"""
```

### 使い方

- `バージョンのタグを付ける`
- `./gradlew jreleaserConfig`で内容を確認する
- `./gradlew clean`でクリーンしておく
- `./gradlew publish`でビルドしたり POM を生成したりしてローカルリポジトリにリリースする
- `./gradlew jreleaserFullRelease`でリリースする

### 参考

- https://central.sonatype.org/publish/publish-portal-gradle/
- https://zenn.dev/orangain/articles/publish-to-maven-central-using-gradle
- https://jreleaser.org/guide/latest/examples/maven/maven-central.html
- https://jreleaser.org/guide/latest/checklist.html
- https://jreleaser.org/guide/latest/reference/release/github.html
