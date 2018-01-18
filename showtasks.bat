call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openBrowser
echo.
echo runcrud.bat has errors - breaking work
goto fail

:openBrowser
start firefox.exe http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Browser has errors - breaking work
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.