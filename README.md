# team a2's project

# DB環境変数の設定
プロジェクトフォルダ(= build.gradleがある階層)に .env ファイルを作成し、中身を以下のようにする（${DATABASE_URL}などを自身で使用するものに書き換えてください）
```
spring.application.name=sample
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USER}
spring.datasource.password=${DATABASE_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```
