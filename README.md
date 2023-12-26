# PluginList
導入しているプラグインをConfigに書き出します。  
以下のように書き出します。

```
pluginlist: '(10): SnowballExplosion[1.1-SNAPSHOT], BuildBlock[1.0.3], Ping[1.0.1-SNAPSHOT],
  PointTP[1.0.0.6-SNAPSHOT], OpenGUI[1.4-SNAPSHOT], AllPlayerKicker[1.0], PluginList[1.0.3-SNAPSHOT],
  GamemodeChanger[1.0.1-SNAPSHOT], ProtocolLib[4.7.0], PlayerWhois[1.2.2-SNAPSHOT]'
```

v1.1からConfigに書き込むほかに、Hastebin(p.yama2211.jp)にリストをPOSTするようになりました。  
プラグインの名前とバージョン(上と同じ)情報がpostされます。

[サンプル1](https://p.yama2211.jp/akonizatoq) / [サンプル2](https://p.yama2211.jp/raw/akonizatoq)  

Hastebinにpostするコードは [kaimu-kun/hastebin.java](https://github.com/kaimu-kun/hastebin.java) を参考にしました。
