VIAaaS
---

VIAaaS - ViaVersion as a Service - Standalone ViaVersion proxy

<img alt="VIAaaS Logo (VIA logo with structural formula of aspirin)" height="200" src="https://viaversion.github.io/VIAaaS/src/main/resources/web/img/logo.webp">

Address generator: https://jo0001.github.io/ViaSetup/aspirin

Public instances: https://github.com/ViaVersion/VIAaaS/wiki/List-of-Public-Instances

Discord: https://viaversion.com/discord

Supported versions: https://viaversion.com/

## Demo

Online mode: https://youtu.be/9MKKjuoe66k

Using with GeyserConnect: https://youtu.be/_LItAIIFmsI

Using with GeyserConnect on offline mode: https://youtu.be/-hZESD61nSU

Offline mode tutorial: https://youtu.be/lPdELnrxmp0

## How does it work?

- [ViaVersion](https://viaversion.com), [ViaBackwards](https://viaversion.com/backwards)
  and [ViaRewind](https://viaversion.com/rewind) translates the connections to backend server.
- VIAaaS auth page stores account credentials in the player's browser local storage.
- It requires a CORS Proxy for calling Mojang APIs.
- Account credentials aren't sent to VIAaaS instance, though it's proxied by CORS Proxy.
- The web page receives and validates the joinGame's session hash from VIAaaS instance.

## Setting up server instance

Download: [GitHub Actions](https://github.com/ViaVersion/VIAaaS/actions) (needs to be logged into GitHub)
or [JitPack](https://jitpack.io/com/github/ViaVersion/VIAaaS/master-SNAPSHOT/VIAaaS-master-SNAPSHOT-all.jar)

### How to download and start VIAaaS server:

```sh
curl -Lf --output VIAaaS-all.jar "https://jitpack.io/com/github/ViaVersion/VIAaaS/master-SNAPSHOT/VIAaaS-master-SNAPSHOT-all.jar"
java -jar VIAaaS-all.jar
```

- Requires Java 11
- Default Minecraft: ```via.localhost``` with port 25565
- Default HTTPS: ```https://localhost:25543/```
- Default WS URL: ```wss://localhost:25543/ws```

### How to create a public server

- You need a DNS wildcard pointing to VIAaaS instance, like ``*.example.com -> 192.168.123.123``. You can
  use [DuckDNS](https://duckdns.org/) DDNS service.
- Configure the hostname in the config
- Open the Minecraft port (25565)
- The HTTPS page needs a valid SSL certificate, you can use [Apache](https://httpd.apache.org/) (with
  a [Let's Encrypt](https://letsencrypt.org/) certificate) as a reverse proxy. See apache_copypasta.txt file.

## CORS Proxy

- Due to Mojang API not allowing CORS request, we need to use a CORS proxy
- For less chance of Mojang seeing the login as suspect, you (the player) should set up a CORS proxy on your machine.
- Note the ending slash in cors-anywhere address
- The default CORS Proxy is hosted at https://crp123-cors.herokuapp.com/
  ([source](https://github.com/creeper123123321/cors-anywhere/))

## Usage for players

You can also connect to ```via.localhost`` and set the address parameters via web page.

#### Offline mode:

- Connect to ```mc.example.net.via.localhost```

#### Online mode:

Web login:

- Go to VIAaaS auth webpage (default is https://localhost:25543/)
- Listen to the username A (you'll use it to connect to the VIAaaS instance).
- Add the account B (you'll use it in backend server).
- Keep the page open
- Connect with your account A to ```mc.example.com._u(account B).via.localhost```
- Approve the login in the webpage

Web login via token caching:

- Open the web page and save your account in your browser
- Send your access token to the instance
- Connect with ```mc.example.com.via.localhost```

Fabric/Forge client:

- Install [OpenAuthMod](https://github.com/RaphiMC/OpenAuthMod) in your client.
- Join the server: ```mc.example.net.via.localhost```
- Approve the login

### Address options

#### Example address:

- ```server.example.net._p25565._v1_12_2._of._uBACKUSERNAME.via.example.com```
- ```server.example.net.v_1_8.via.example.com```
- It's inspired by [Tor2web](https://www.tor2web.org/) proxies.

#### Address parts:

- You can use ``(option)_(value)`` too, like ``p_25565``.
- ```server.example.net```: backend server address
- ```_p```: backend port
- ```_v```: backend version ([protocol id](https://wiki.vg/Protocol_version_numbers) or name, replace ``.`` with ``_``)
  . ```AUTO``` is default (with 1.8 as fallback).
- ```_o```: ```true``` to force online mode in frontend, ```false``` to force offline mode in frontend. If not set, it
  will be based on backend online mode.
- ```_u```: username to use in backend connection (default is front-end username)
- ```via.example.com```: instance address (defined in config)

## WARNING

- VIAaaS may trigger anti-cheats, due to block, item, movement and other differences between versions. USE AT OWN RISK.
- Take care of browser local storage. Check for XSS vulnerabilities on your domain.
- Check the security of CORS proxy, it will be used for calling to Mojang API.
- Mojang may [lock](https://wiki.geysermc.org/geyser/common-issues/#mojang-resetting-account-credentials) your account
  when API is called from a suspect IP address.

## FAQ

### Accounts

#### Why to use an online webpage for online mode?:

- It's easier to maintain in that way, because providing login via chat requires encoding and decoding more packets,
  which reduces maintainability.
- It allows your account password and token to be kept with you.

#### How to use Microsoft Account?:

- If you are using a public VIAaaS instance, use this page https://viaversion.github.io/VIAaaS/ and configure the
  WebSocket address.
- If you're an administrator of the instance, edit ```config/web/js/config.js``` (default is in the jar) and
  configure your [Azure Client ID](https://wiki.vg/Microsoft_Authentication_Scheme#Microsoft_OAuth_Flow) and your domain
  whitelist.

### Connection

#### How to use IPv6?:

- When listening to 0.0.0.0, it should listen on IPv6 too.
- The hostname parser currently doesn't support direct IPv6, but you can use a DNS name with https://sslip.io/

#### I'm getting a DNS error/"Unknown host" while connecting to via.localhost

- Try configuring ```via.localho.st``` as hostname suffix instead

#### How to use with Geyser?

- Set the parameters in Geyser's `address` field:
  ```yml
  remote:
    # The IP address of the remote (Java Edition) server
    address: 2b2t.org._v1_12_2.via.localhost
  ```
- If you are using a public GeyserConnect instance: connect to a publicly available VIAaaS instance,
  like ```mc.example.com._v1_8.via.example.net``` as a Java Edition server.

#### Can I use it to connect to .onion Minecraft hidden servers?

- You can use .onion addresses if the instance is proxying the backend connections to TOR. Note that VIAaaS may log your
  requests, and that your DNS queries may be unencrypted.

#### Can you support more versions / Is there some alternative?

- See [DirtMultiVersion](https://github.com/DirtPowered/DirtMultiversion) and RK_01's ViaProxy server (
  viaproxy.raphimc.net)

#### Can I customize the files of HTTP server?

- Add files to ``config/web/`` directory