# wtf-intellij

![Build](https://github.com/Paulpanther/wtf-intellij/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/MARKETPLACE_ID.svg)](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/MARKETPLACE_ID.svg)](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID)

<!-- Plugin description -->
Intellij Plugin for the WTF language https://github.com/antoniusnaumann/wtf-lang
<!-- Plugin description end -->

## How to run
1. Import into intellij as gradle project
2. Install `Grammar-Kit` plugin
3. Right-click `src/main/kotlin/com/paulmethfessel/wtfintellij/lang/wtf.bnf` and `Generate Parser Code`
4. Right-click `src/main/kotlin/com/paulmethfessel/wtfintellij/lang/_WtfLexer.flex` and `Run JFlex Generator`
5. Run gradle task `Run Plugin`
