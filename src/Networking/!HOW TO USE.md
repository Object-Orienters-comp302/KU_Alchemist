# This is our main Networking Class Directory

## How does it work?
We have a GameServer and N GameClients. Each client connects to the server and receives two sockets.
ObjectInputStream and ObjectOutputStream. This way we can send and receive objects to and from clients.


## How to use?

We start the GameServer first so that the clients can connect to the server.

Then, we start the client, when a client is started it connects to the server and receives two sockets.
One for listening and one for sending updates.

**TO SEND UPDATES:** Client.sendAction(GameAction action);
Right now the client only sends and receives GameActions, but this can be changed to any object with ease.


# MAIN IDEA:
When a client sends updates, the server receives this update and broadcasts it to all of the clients.
This way the models are updated between all clients. The idea is that once a player changes their model, this change will be propagated to all of the clients and each client will update their model accordingly.
Letting us sync the models of all of our clients.
