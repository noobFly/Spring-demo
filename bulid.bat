@set JAVA_TOOL_OPTIONS=-Dfile.encoding=GBK
@echo ѡ�񹤳̽�Ҫ���еĻ�����������ź󰴻س���������
@echo.
@echo #######################################################################
@echo ##                       1. ��������                                 ##
@echo ##          	         2. ���Ի���                                 ##
@echo ##                       3. Ԥ��������                               ##
@echo ##                       4. ��������                                 ##
@echo #######################################################################
@echo.

@set env=""

:input
@set /p input=��������ţ�
@if %input%==1 (
	@set env=dev
) else if %input%==2 (
	@set env=test
) else if %input%==3 (
	@set env=pre
) else if %input%==4 (
	@set env=pro
) else (
	@echo �Ƿ������룡�����ԣ�
	@echo.
	goto input
)

:: �˴���Ҫ���û��޸�MAVEN_OPTS��������ִ��mvn install����ʱ���ܻ����OutOfMemoryError����
:: �Ⱥź��治�ܼ�����
@set MAVEN_OPTS=-Xmx512m -XX:MaxPermSize=128m


@call mvn clean install -Dmaven.test.skip=true -Denv=%env% -e -U
@popd

@echo.
@if %ERRORLEVEL%==0 (
	@echo ���̹�����ϣ�
) else (
	@echo ���̹���ʧ�ܣ�
)

@echo.
@echo ��������˳����� & pause>nul