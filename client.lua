local socket = require("socket")
host = host or "172.168.154.0"
port = port or 8080
if arg then
	host = arg[1] or host
	port = arg[2] or port
end
print("Trying connecting to host '" ..host.. "' and port " ..port.. "...")
c = assert(socket.connect(host, port))
print("You Are Connected! Please write message (empty line to stop):")
l = io.read()
while l and l ~= "" and not e do
	assert(c:send(l .. "\n"))

	msg, err = c:receive()
	if not err then
		print("Reversed Message: " .. msg)

	end

	l = io.read()
end
