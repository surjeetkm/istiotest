while true
do
 	response=$(curl -o -I -L --write-out %(http_code) http://34.67.16.138:8080/getmessage)
echo "\nResponseCode...."$response
echo "\nDone.....\n\n"
sleep 1
done