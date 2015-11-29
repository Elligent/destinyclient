@echo off
SET LIBRARY_PATH=-Djava.library.path=lib\native
SET CLIENT=client.jar
SET UPDATER=updater.jar

:Start
java %LIBRARY_PATH% -jar %UPDATER%
IF errorlevel 1 Goto Updated
java %LIBRARY_PATH% -jar %CLIENT%
Goto End

:Wait
Pause
Goto End

:Updated
msg * "The updater has been updated, please restart the game!"
Goto End

:End