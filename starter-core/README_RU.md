# statter-core

Это основной модуль для запуска desktop приложения. <br>
Жизненный цикл, включает следующие этапы во время запуска приложения:
<ol>
<li>Определение среды (ОС).</li>
<li>Проверка дополнительных требований к запуску (свободного места на диске, прав доступа в рабочую дирекорию, правильная установка и доступ в /temp директории, корректное отображение шрифтов, решение проблем с обновлением KB4515384 (для Windows OC)).</li>
<li>Получение конфигов для запуска приложения, таких как зависимости, файлы ресурсы, параметры запуска, аргументы запуска, версия приложения.</li>
<li>Подготовка ресурсов для запуска (обновление версии приложения), валидация текущих ресурсов по хэш-сумме, таких как зависимости и ресурсы, jre для разных ОС и загрузка несуществующих ресурсов.</li>
<li>Запуск самого приложения.</li>
</ol>

*Может запускать в офлайн режиме, для этого конфиги кэшируются, это позволяет хранить большинство конфигов на стороне сервера.<br>

Класс by.dgev.Main имеет следующие аргументы которые можно изменить:<br>

| Аргумент | По умолчанию | Описание |
| :------: | :-----------: | :-------: |
| -memory| 500 | Размер необходимого свободного места на диске для загрузки приложения |  
| -uriAppConfig| http://127.0.0.1:81/starter-app/ | URI по которому доступен appConfig.json, который содержит в себе всю информациюя о запускаемом приложении, этот конфиг используется всеми приложениями по умолчанию. URI должен быть указан без версии, см. описание параметра версии|  
| -workDirectory| starter  |Рабочий каталог, в который будут загружаться необходимые для приложения файлы и в котором будет запускаться приложение|  
| -version| 1.0 | Указывает версию запускаемого приложения. Поэтому будет использоваться конфиг http://localhost:81/app/1.0/appConfig.json для версии 1.0. Таким образом, мы можем установить старые версии приложения| 
|-cacheDirectory| starter/cache  | Директория для хранения кэшированных конфигов  |  
|-urlConnection| http://www.google.com, http://www.baidu.com | Список сайтов для проверки подключения к Интернету |
|-attempts| 3 | Количество попыток на восстановление соединения|
|-connectTimeout| 60000  |установка значения setConnectTimeout|
|-socketTimeout| 60000  |установка значения setSocketTimeout|
|-timeToLife| 600000 | Время обновления файла в секундах. После истечения данного времени файл является не актуальным |
|-stop|false| Аргумент для автоматического закрытия приложения после установки. Используется для тестов|