#check if threads are running
netstat -ano | findstr 8080

#find the task
tasklist | findstr 12345


#kill it
taskkill /PID 12345 /F
