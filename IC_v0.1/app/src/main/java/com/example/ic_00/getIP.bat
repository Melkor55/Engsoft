@echo off
set ip_address_string="IPv4 Address"
rem Uncomment the following line when using older versions of Windows without IPv6 support (by removing "rem")
rem set ip_address_string="IP Address"
rem echo Network Connection Test
rem for /f "usebackq tokens=2 delims=:" %%f in (`ipconfig ^| findstr /c:%ip_address_string%`) do echo Your IP Address is: %%f
set scriptpath=%~dp0
rem echo %scriptpath%   :: will output c:\users\user\Desktop
for /f "usebackq tokens=2 delims=:" %%f in (`ipconfig ^| findstr /c:%ip_address_string%`) do (echo %%f > "%scriptpath%/IP.txt")
rem '>' - override | '>>' - append