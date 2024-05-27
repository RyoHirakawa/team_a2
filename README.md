# team a2's project

# DB環境変数の設定
プロジェクトフォルダ(= build.gradleがある階層)に .env ファイルを作成し、中身を以下のようにする。
${DATABASE_URL}、${DATABASE_USER}、${DATABASE_PASSWORD}を自身で使用するものに書き換えてください。
```
DATABASE_URL=jdbc:mysql://localhost:3306/DATABASENAME #DBの名前
DATABASE_USER=NAME #ユーザー名
DATABASE_PASSWORD=PASSWORD #データベースのパスワード
```
