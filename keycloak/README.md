Для запуска keycloak используй команду
docker run -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin quay.io/keycloak/keycloak:15.0.2

1) В браузере открыть http://localhost:8080/auth/admin/master/console/#/realms/master/clients
2) Логин/пароль admin/admin
3) Слева на панели выбери "Import", импортируй файл realm-export.json из этой папки, выстави "If resource exists" в  "Skip"
4) Перейди в панель Clients, выбери gateway, перейди на вкладку Credentials, жмакни "regenerate secret"
5) Полученный секрет копируй в application.yaml, в поле "client_secret"
6) Перейди на боковой панели в Realm Settings, оттуда на вкладку Tokens. Выстави: Access Token Lifespan = 120 minutes, Lifetime of the Request URI for Pushed Authorization Request = 120 minutes и сохрани
7) Можно запускать сервисы: eurekaserver - gateway - и так далее


Для тестирования через сваггер выполни авторизацию в верхем левом углу, подставив соответствующие client_id и client_secret
из application.yaml сервиса gateway (scope'ы) можно выбрать все.