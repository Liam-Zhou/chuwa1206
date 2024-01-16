### SpringBoot

1. [annotations.md](./annotations.md)

2. These annotations use the JPA, Java persistence Architecture to specify the mapping of Java objects to database tables. 

   The first annotation is used to specify the mapping for the `name` field in the Java entity class to the corresponding column in the database table. `columnDefinition` is used to define the SQL data type and any additional constraints for the column. It specifies that the column is of type `varchar(255)` and has a default value of 'John Snow'.

   The second annotation is used to specify the mapping for the `studentName` field. `name` is used to define the name of the column in the database, which is set to "STUDENT_NAME". `length` specifies the maximum length of the column, which is 50 characters. `nullable=false` means the column must have a value. `unique = false` means that there can be duplicate values.

3. ```java
   first_name
   operating_system
   ```

4. There are 4 layers: **Presentation Layer, Business Layer, Persistence Layer, and Database**. 

​	The presentation layer also called the controller, handles incoming HTTP requests and manages the interaction between the client and the application. It also do some authentication.

​	The business layer, or the service layer, does the business logic and acts as an intermediary between the presentation layer and the data access layer. 

​	The persistence layer is responsible for interacting with the database or any external data sources. It specifies the storage logic.

​	The database is the actual databse.

5. flow:
   1. Postman sends an HTTP request to the Spring Boot application.
   2. The controller receives a request and map it to the URL. The controller validates and processes the request data, then calls a service method.
   3. The service layer handles business logic and operations, and will call the repository layer to interact with the database if needed. 
   4. The repository layer performs database operations and returns data back to the service layer. 
   5. The service layer receives the result from the repository layer and will return to the controller layer when the logic is done.
   6. The controller layer will send the result back to the client.

6. Application.properties is a properties file format, where configurations are defined as **key-value pairs**.

7. Screen shot:

   ![image-20240115003150214](C:\Users\alisha\AppData\Roaming\Typora\typora-user-images\image-20240115003150214.png)

### REST API

1. 5 GET APIs with different response type

   1. API: GET  https://www.bilibili.com/

      Request Body: N/A (since it is a GET request)

   2. API: GET https://www.bilibili.com/video/BV1f94y1u7ti/?spm_id_from=333.1007.tianma.3-2-6.click&vd_source=a4d4a06e2007994412aec6b7e330f43b
   3. API: GET https://www.google.com/search?q=bilibili&sca_esv=598503895&rlz=1C1RXQR_enUS1071US1071&sxsrf=ACQVn08bY4eNlh79gLq3e6ukhcTOm41ifA%3A1705301231137&ei=79SkZZSECMiuptQP8LKvwAw&ved=0ahUKEwjUt_eQ5t6DAxVIl4kEHXDZC8gQ4dUDCBE&uact=5&oq=bilibili&gs_lp=Egxnd3Mtd2l6LXNlcnAiCGJpbGliaWxpMhAQABiABBiKBRhDGLEDGIMBMgoQABiABBiKBRhDMggQABiABBixAzIIEAAYgAQYsQMyCxAAGIAEGLEDGIMBMgUQABiABDIFEAAYgAQyBRAuGIAEMgUQABiABDIFEAAYgARIwi1QvAhYlytwA3gBkAEAmAFuoAGjCKoBBDEzLjG4AQPIAQD4AQGoAhLCAgoQABhHGNYEGLADwgINEAAYgAQYigUYQxiwA8ICExAuGIAEGIoFGEMYyAMYsAPYAQHCAgoQIxiABBiKBRgnwgIWEC4YgAQYFBiHAhixAxiDARjHARjRA8ICEBAAGIAEGBQYhwIYsQMYgwHCAgsQLhiABBjHARjRA8ICJRAuGIAEGBQYhwIYsQMYgwEYxwEY0QMYlwUY3AQY3gQY4ATYAQLCAhkQLhiABBiKBRhDGLEDGIMBGMkDGMcBGNEDwgILEAAYgAQYigUYkgPCAigQLhiABBiKBRhDGLEDGIMBGMkDGMcBGNEDGJcFGNwEGN4EGOAE2AECwgIWEC4YgAQYigUYQxixAxiDARjHARjRA8ICJRAuGIAEGIoFGEMYsQMYgwEYxwEY0QMYlwUY3AQY3gQY4ATYAQLCAgsQLhiDARixAxiABMICBxAjGOoCGCfCAhMQABiABBiKBRhDGOoCGLQC2AEDwgIWEC4YgAQYigUYQxjIAxjqAhi0AtgBBMICCxAAGIAEGIoFGJECwgIOEC4YgAQYsQMYxwEY0QPCAhEQLhiABBixAxiDARjHARjRA8ICEBAuGIAEGIoFGEMYxwEY0QPCAgoQLhiABBiKBRhDwgILEC4YgAQYsQMYgwHCAhMQLhiABBiKBRhDGLEDGIMBGNQCwgINEAAYgAQYigUYQxixA8ICEBAuGIAEGIoFGEMYsQMYgwHCAg4QABiABBiKBRixAxiDAcICDhAuGIAEGIoFGLEDGIMBwgINEC4YgAQYxwEY0QMYCuIDBBgAIEGIBgGQBgy6BgQIARgIugYGCAIQARgUugYGCAMQARgBugYGCAQQARgI&sclient=gws-wiz-serp
   4. API: GET 
   5. API: GET

2. 5 Post API with json request body

   1. POST api/v1/posts

      request body:

      ```java
      {
        "username": "username",
        "email": "email",
        "password": "password"
      }
      ```

      

   2. POST api/v1/posts/{id}

3. 3 PUT API with json request body

4. 2 DELETE API

5. Each example with 404, 401,500 and any http status codes you know

   1. https://www.bilibili.com/ Response status: `200 ok`

      Response:

      ```
      <!DOCTYPE html>
      <html lang="zh-CN" class="gray">
          <head>
              <meta charset="UTF-8"/>
              <title>哔哩哔哩 (゜-゜)つロ 干杯~-bilibili</title>
              <meta name="description" content="哔哩哔哩（bilibili.com)是国内知名的视频弹幕网站，这里有及时的动漫新番，活跃的ACG氛围，有创意的Up主。大家可以在这里找到许多欢乐。"/>
              <meta name="keywords" content="bilibili,哔哩哔哩,哔哩哔哩动画,哔哩哔哩弹幕网,弹幕视频,B站,弹幕,字幕,AMV,MAD,MTV,ANIME,动漫,动漫音乐,游戏,游戏解说,二次元,游戏视频,ACG,galgame,动画,番组,新番,初音,洛天依,vocaloid,日本动漫,国产动漫,手机游戏,网络游戏,电子竞技,ACG燃曲,ACG神曲,追新番,新番动漫,新番吐槽,巡音,镜音双子,千本樱,初音MIKU,舞蹈MMD,MIKUMIKUDANCE,洛天依原创曲,洛天依翻唱曲,洛天依投食歌,洛天依MMD,vocaloid家族,OST,BGM,动漫歌曲,日本动漫音乐,宫崎骏动漫音乐,动漫音乐推荐,燃系mad,治愈系mad,MAD MOVIE,MAD高燃"/>
              <meta name="renderer" content="webkit"/>
              <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
              <meta name="spm_prefix" content="333.1007"/>
              <meta name="referrer" content="no-referrer-when-downgrade"/>
              <meta name="applicable-device" content="pc">
              <meta http-equiv="Cache-Control" content="no-transform"/>
              <meta http-equiv="Cache-Control" content="no-siteapp"/>
              <meta name="server_render" content="is_server_render"/>
              <link rel="dns-prefetch" href="//s1.hdslb.com"/>
              <link rel="apple-touch-icon" href="//static.hdslb.com/mobile/img/512.png"/>
              <link rel="shortcut icon" href="https://www.bilibili.com/favicon.ico?v=1"/>
              <link rel="canonical" href="https://www.bilibili.com/"/>
              <link rel="alternate" media="only screen and (max-width: 640px)" href="https://m.bilibili.com"/>
              <link rel="stylesheet" href="//s1.hdslb.com/bfs/static/jinkela/long/font/medium.css" media="print" onload="this.media='all'"/>
              <link rel="stylesheet" href="//s1.hdslb.com/bfs/static/jinkela/long/font/regular.css" media="print" onload="this.media='all'"/>
              <script>
                  window._BiliGreyResult = {
                      "method": "gray",
                      "grayVersion": "12826"
                  }
              </script>
              <script src="//s1.hdslb.com/bfs/static/laputa-home/client/assets/svgfont.2cee4853.js" async></script>
              <script src="https://www.bilibili.com/gentleman/polyfill.js?features=es2015%2Ces2016%2Ces2017%2Ces2018%2Ces2019%2Ces2020%2Ces2021%2Ces2022%2CglobalThis&flags=gated"></script>
              <script type="text/javascript" src="//s1.hdslb.com/bfs/static/jinkela/long/bmg/register/fallback.js"></script>
              <link rel="stylesheet" href="//s1.hdslb.com/bfs/static/jinkela/long/laputa-css/map.css"/>
              <link rel="stylesheet" href="//s1.hdslb.com/bfs/static/jinkela/long/laputa-css/light_u.css"/>
              <link id="__css-map__" rel="stylesheet" href="//s1.hdslb.com/bfs/static/jinkela/long/laputa-css/light.css"/>
              <script>
                  window.__SERVER_CONFIG__ = {
                      "serverBuvid": "6FCFCC80-B708-86D5-44D8-4D386D5BBE7264496infoc",
                      "homeFeedColumn": "4",
                      "browserResolution": "905-833",
                      "isModern": true,
                      "aiexp": "3",
                      "remove_channel_lift": 0,
                      "ab_test": {
                          "for_ai_home_version": "V_FAVOR_WATCH_LATER",
                          "tianma_banner_inline": "CONTROL",
                          "login_dialog_version": "V0",
                          "h5_read_awaken_app": "B",
                          "home_pop_window": "V1",
                          "channel_show_back_btn": "HIDDEN",
                          "nano_pcdn_version": "V_PCDN",
                          "in_theme_version": "CLOSE",
                          "storage_back_btn": "HIDE",
                          "web_homepage_video_continuation": "OPEN",
                          "clean_version_old": "GO_NEW",
                          "top_switch": "SHOW",
                          "exit_feed_btn": "HIDE",
                          "force_to_feed": "GO",
                          "bmg_fallback_version": "FALLBACK",
                          "enable_web_push": "DISABLE",
                          "desktop_download_tip": "SHOW"
                      },
                      "constants": {
                          "loginBackBlockCountingSecond": 210,
                          "previewTipCountingSecond": 1,
                          "previewCountingSecond": 4,
                          "nanoVersionHash": "a8c001e3",
                          "nanoVersionPipHash": "29587de4",
                          "nanoVersionPcdnHash": "57abf745",
                          "tianma_banner_inline_V0": -1,
                          "tianma_banner_inline_V1": 10,
                          "continuousHistoryThreshold": 1200,
                          "continuousHistoryVisibleDuration": 8
                      },
                      "uniq_page_id": 359192858668
                  };
              </script>
              <script type="text/javascript">
                  window.__NANO_VERSION_HASH__ = "a8c001e3"
              </script>
              <script type="text/javascript">
                  // 当没有值时，给一个合适页面使用的
                  if (!window.__NANO_VERSION_HASH__) {
                      window.__NANO_VERSION_HASH__ = 'a8c001e3'
                  }
              </script>
              <script type="text/javascript">
                  ;(function() {
                      if (document.querySelector('meta[name=server_render]')) {
                          return
                      }
                      var ua = window.navigator.userAgent
                        , agents = ['Android', 'iPhone', 'SymbianOS', 'Windows Phone', 'iPod']
                        , isPC = true
                      if (/\sVR\s/g.test(ua))
                          return
                      for (var i = 0, len = agents.length; i < len; i++) {
                          if (ua.indexOf(agents[i]) > 0) {
                              isPC = false
                              break
                          }
                      }
                      if (!isPC) {
                          window.location.href = window.location.href.replace('www', 'm')
                      }
                  }
                  )()
              </script>
              <script type="text/javascript">
                  window.spmReportData = {}
                  window.reportConfig = {
                      sample: 1,
                      msgObjects: 'spmReportData',
                      errorTracker: true
                  }
                  function getCookie(name) {
                      var reg = new RegExp('(^| )' + name + '=([^;]*)(;|$)')
                      var r = document.cookie.match(reg)
                      return r ? unescape(r[2]) : null
                  }
                  function fsrCb() {
                      if (window.performance && window.performance.timing) {
                          window.performance.timing.firstscreenfinish = new Date().getTime()
                      }
                  }
                  // 图片降级使用
                  function imgOnError(img) {
                      typeof window.imgAutoFallbackOnError === 'function' && window.imgAutoFallbackOnError(img)
                  }
                  // 图片降级使用
                  function imgOnLoad(img) {
                      typeof window.imgAutoFallbackOnLoad === 'function' && window.imgAutoFallbackOnLoad(img)
                  }
                  function lqipCb(img) {
                      var lqip = img && img.parentNode && img.parentNode.querySelector('.lqip')
                      if (lqip) {
                          lqip.classList.add('is-active')
                      }
                  }
                  if (history.scrollRestoration) {
                      history.scrollRestoration = 'manual'
                  }
                  window.page_load_time = Date.now()
              </script>
              <script type="text/javascript">
                  if (!window.abtest) {
                      window.abtest = {
                          'b_ut': getCookie('b_ut'),
                          'home_version': 'V_FAVOR_WATCH_LATER',
                          'i-wanna-go-back': getCookie('i-wanna-go-back'),
                          'in_new_ab': true,
                          'ab_version': {
                              "for_ai_home_version": "V_FAVOR_WATCH_LATER",
                              "tianma_banner_inline": "CONTROL",
                              "login_dialog_version": "V0",
                              "h5_read_awaken_app": "B",
                              "home_pop_window": "V1",
                              "channel_show_back_btn": "HIDDEN",
                              "nano_pcdn_version": "V_PCDN",
                              "in_theme_version": "CLOSE",
                              "storage_back_btn": "HIDE",
                              "web_homepage_video_continuation": "OPEN",
                              "clean_version_old": "GO_NEW",
                              "top_switch": "SHOW",
                              "exit_feed_btn": "HIDE",
                              "force_to_feed": "GO",
                              "bmg_fallback_version": "FALLBACK",
                              "enable_web_push": "DISABLE",
                              "desktop_download_tip": "SHOW"
                          },
                          'ab_split_num': {
                              "for_ai_home_version": 186,
                              "tianma_banner_inline": 186,
                              "login_dialog_version": 49,
                              "h5_read_awaken_app": 11,
                              "home_pop_window": 9,
                              "channel_show_back_btn": 93,
                              "nano_pcdn_version": 38,
                              "in_theme_version": 43,
                              "storage_back_btn": 35,
                              "web_homepage_video_continuation": 74,
                              "clean_version_old": 1,
                              "top_switch": 10,
                              "exit_feed_btn": 52,
                              "force_to_feed": 26,
                              "bmg_fallback_version": 55,
                              "enable_web_push": 9,
                              "desktop_download_tip": 20
                          },
                      }
                  }
              </script>
              <script type="text/javascript" src="//s1.hdslb.com/bfs/seed/log/report/log-reporter.js"></script>
              <script src="//s1.hdslb.com/bfs/seed/media-preview/core.4fe40c36.js"></script>
              <!--preload-fetch-->
              <link rel="preload" href="//s1.hdslb.com/bfs/static/laputa-home/client/assets/load-error.685235d2.png" as="image" type="image/png" crossorigin>
              <link rel="preload" href="//s1.hdslb.com/bfs/static/laputa-home/client/assets/guidePopupBg.fad6f2b3.gif" as="image" type="image/gif" crossorigin>
              <link rel="preload" href="//s1.hdslb.com/bfs/static/laputa-home/client/assets/login-guide.68b48c4c.png" as="image" type="image/png" crossorigin>
              <link rel="preload" href="//s1.hdslb.com/bfs/static/laputa-home/client/assets/playing.a9a5e899.gif" as="image" type="image/gif" crossorigin>
              <link rel="preload" href="//s1.hdslb.com/bfs/static/laputa-home/client/assets/vip-login-banner.c0cbe3b2.png" as="image" type="image/png" crossorigin>
              <link rel="preload" href="//s1.hdslb.com/bfs/static/laputa-home/client/assets/wlpip-playing-active.0841ce3d.png" as="image" type="image/png" crossorigin>
              <script type="module" crossorigin src="//s1.hdslb.com/bfs/static/laputa-home/client/assets/index.fe6dabee.js"></script>
              <link rel="modulepreload" href="//s1.hdslb.com/bfs/static/laputa-home/client/assets/vendor.f1b03f91.js">
              <link rel="stylesheet" href="//s1.hdslb.com/bfs/static/laputa-home/client/assets/vendor.54c577aa.css">
              <link rel="stylesheet" href="//s1.hdslb.com/bfs/static/laputa-home/client/assets/index.b11b7acb.css">
              <script type="module">
                  try {
                      import("_").catch(()=>1);
                  } catch (e) {}
                  window.__vite_is_dynamic_import_support = true;
              </script>
              <script type="module">
                  !function() {
                      if (window.__vite_is_dynamic_import_support)
                          return;
                      console.warn("vite: loading legacy build because dynamic import is unsupported, syntax error above should be ignored");
                      var e = document.getElementById("vite-legacy-polyfill")
                        , n = document.createElement("script");
                      n.src = e.src,
                      n.onload = function() {
                          System.import(document.getElementById('vite-legacy-entry').getAttribute('data-src'))
                      }
                      ,
                      document.body.appendChild(n)
                  }();
              </script>
          </head>
          <body>
              <script>
                  // bili-mirror 告警上报
                  window.__MIRROR_CONFIG__ = {
                      origin: 'main',
                      module: 'home-page',
                      spmId: '333.1007',
                      config: {
                          isAutoInit: true,
                          // 注意这个属性，isAutoInit 为 true ,js 加载完成后会自动执行 init 方法
                          whiteScreen: {
                              maxLoop: 10,
                              checkDom: ['#i_cecream'],
                              callback: status=>{
                                  console.log('白屏检测是否正常', status)
                              }
                              ,
                              isSkeleton: false
                          }
                      }
                  }
              </script>
              <script src="//s1.hdslb.com/bfs/seed/jinkela/short/b-mirror/biliMirror.umd.mini.js"></script>
              <div class="browser-tip"></div>
              <script>
                  if (window.__SERVER_CONFIG__ && window.__SERVER_CONFIG__.isModern === false) {
                      document.querySelector('.browser-tip').innerHTML = '<div class="title">当前浏览器版本较低，为保证您的使用体验，建议使用最新版本的浏览器访问。</div>'
                  }
                  if (/(Mac|iPhone|iPod|iPad)/i.test(window.navigator.platform)) {
                      document.body.classList.add('mac')
                  } else {
                      document.body.classList.add('win')
                  }
              </script>
              <div id="i_cecream">
                  <!--[-->
                  <!--[-->
                  <div class="bili-video-card__wrap __scale-wrap __adblockhidden" data-v-7f4a51a0>
                      <a href="//cm.bilibili.com" data-target-url="**" data-v-7f4a51a0></a>
                  </div>
                  <!---->
                  <!--]-->
                  <div class="bili-feed4">
                      <!--[-->
                      <div class="bili-header large-header">
                          <div class="bili-header__bar">
                              <ul class="left-entry">
                                  <li>
                                      <a href="//www.bilibili.com" class="entry-title">
                                          <svg width="18" height="18" viewbox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg" class="zhuzhan-icon">
                                              <path fill-rule="evenodd" clip-rule="evenodd" d="M3.73252 2.67094C3.33229 2.28484 3.33229 1.64373 3.73252 1.25764C4.11291 0.890684 4.71552 0.890684 5.09591 1.25764L7.21723 3.30403C7.27749 3.36218 7.32869 3.4261 7.37081 3.49407H10.5789C10.6211 3.4261 10.6723 3.36218 10.7325 3.30403L12.8538 1.25764C13.2342 0.890684 13.8368 0.890684 14.2172 1.25764C14.6175 1.64373 14.6175 2.28484 14.2172 2.67094L13.364 3.49407H14C16.2091 3.49407 18 5.28493 18 7.49407V12.9996C18 15.2087 16.2091 16.9996 14 16.9996H4C1.79086 16.9996 0 15.2087 0 12.9996V7.49406C0 5.28492 1.79086 3.49407 4 3.49407H4.58579L3.73252 2.67094ZM4 5.42343C2.89543 5.42343 2 6.31886 2 7.42343V13.0702C2 14.1748 2.89543 15.0702 4 15.0702H14C15.1046 15.0702 16 14.1748 16 13.0702V7.42343C16 6.31886 15.1046 5.42343 14 5.42343H4ZM5 9.31747C5 8.76519 5.44772 8.31747 6 8.31747C6.55228 8.31747 7 8.76519 7 9.31747V10.2115C7 10.7638 6.55228 11.2115 6 11.2115C5.44772 11.2115 5 10.7638 5 10.2115V9.31747ZM12 8.31747C11.4477 8.31747 11 8.76519 11 9.31747V10.2115C11 10.7638 11.4477 11.2115 12 11.2115C12.5523 11.2115 13 10.7638 13 10.2115V9.31747C13 8.76519 12.5523 8.31747 12 8.31747Z" fill="currentColor"></path>
                                          </svg>
                                          <span>首页</span>
                                      </a>
                                  </li>
                                  <!---->
                                  <!--[-->
                                  <!--[-->
                                  <li class="v-popover-wrap">
                                      <!--[-->
                                      <a href="//www.bilibili.com/anime/" target="_blank" class="default-entry">
                                          <span>番剧</span>
                                      </a>
                                      <!--]-->
                                      <!---->
                                  </li>
                                  <!---->
                                  <!--]-->
                                  <!--[-->
                                  <li class="v-popover-wrap">
                                      <!--[-->
                                      <a href="//live.bilibili.com" target="_blank" class="default-entry">
                                          <span>直播</span>
                                      </a>
                                      <!--]-->
                                      <!---->
                                  </li>
                                  <!---->
                                  <!--]-->
                                  <!--[-->
                                  <li class="v-popover-wrap">
                                      <!--[-->
                                      <a href="//game.bilibili.com/platform" target="_blank" class="default-entry">
                                          <span>游戏中心</span>
                                      </a>
                                      <!--]-->
                                      <!---->
                                  </li>
                                  <!---->
                                  <!--]-->
                                  <!--[-->
                                  <li class="v-popover-wrap">
                                      <!--[-->
                                      <a href="//show.bilibili.com/platform/home.html?msource=pc_web" target="_blank" class="default-entry">
                                          <span>会员购</span>
                                      </a>
                                      <!--]-->
                                      <!---->
                                  </li>
                                  <!---->
                                  <!--]-->
                                  <!--[-->
                                  <li class="v-popover-wrap">
                                      <!--[-->
                                      <a href="//manga.bilibili.com?from=bill_top_mnav" target="_blank" class="default-entry">
                                          <span>漫画</span>
                                      </a>
                                      <!--]-->
                                      <!---->
                                  </li>
                                  <!---->
                                  <!--]-->
                                  <!--[-->
                                  <li class="v-popover-wrap">
                                      <!--[-->
                                      <a href="//www.bilibili.com/match/home/" target="_blank" class="default-entry">
                                          <span>赛事</span>
                                      </a>
                                      <!--]-->
                                      <!---->
                                  </li>
                                  <!---->
                                  <!--]-->
                                  <!--[-->
                                  <!---->
                                  <!---->
                                  <!--]-->
                                  <!--[-->
                                  <!---->
                                  <!---->
                                  <!--]-->
                                  <!--]-->
                                  <li class="v-popover-wrap">
                                      <!--[-->
                                      <a href="//app.bilibili.com" target="_blank" class="download-entry download-client-trigger">
                                          <svg width="16" height="16" viewbox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg" class="download-client-trigger__icon">
                                              <path d="M7.23181 8.65895V1.75796C7.23181 1.33935 7.57582 1 8.00018 1C8.42453 1 8.76854 1.33935 8.76854 1.75796V8.67097L9.98589 7.47009C10.286 7.17409 10.7725 7.17409 11.0725 7.47009C11.3726 7.7661 11.3726 8.24601 11.0725 8.54201L8.54958 11.0308C8.24952 11.3268 7.76302 11.3268 7.46295 11.0308L4.94002 8.54201C4.63995 8.24601 4.63995 7.7661 4.94002 7.47009C5.24008 7.17409 5.72658 7.17409 6.02665 7.47009L7.23181 8.65895Z" fill="currentColor"></path>
                                              <path d="M3.48023 4.29936C2.40686 4.29936 1.53672 5.15772 1.53672 6.21656V11.5669C1.53672 12.6257 2.40686 13.4841 3.48023 13.4841H12.5198C13.5931 13.4841 14.4633 12.6257 14.4633 11.5669V6.21656C14.4633 5.15772 13.5931 4.29936 12.5198 4.29936H11.6158C11.1915 4.29936 10.8475 3.96001 10.8475 3.5414C10.8475 3.12279 11.1915 2.78344 11.6158 2.78344H12.5198C14.4418 2.78344 16 4.3205 16 6.21656V11.5669C16 13.4629 14.4418 15 12.5198 15H3.48023C1.55815 15 0 13.4629 0 11.5669V6.21656C0 4.3205 1.55815 2.78344 3.48023 2.78344H4.38418C4.80853 2.78344 5.15254 3.12279 5.15254 3.5414C5.15254 3.96001 4.80853 4.29936 4.38418 4.29936H3.48023Z" fill="currentColor"></path>
                                          </svg>
                                          <span>下载客户端</span>
                                          <!---->
                                      </a>
                                      <!--]-->
                                      <!---->
                                  </li>
                              </ul>
                              <div class="center-search-container">
                                  <div class="center-search__bar">
                                      <form id="nav-searchform" class="" style="border-radius:8px 8px 8px 8px;">
                                          <div class="nav-search-content">
                                              <input class="nav-search-input" type="text" autocomplete="off" accesskey="s" maxlength="100" x-webkit-speech="" x-webkit-grammar="builtin:translate" value="" placeholder="" title="">
                                              <div class="nav-search-clean">
                                                  <svg width="16" height="16" viewbox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                      <path fill-rule="evenodd" clip-rule="evenodd" d="M8 14.75C11.7279 14.75 14.75 11.7279 14.75 8C14.75 4.27208 11.7279 1.25 8 1.25C4.27208 1.25 1.25 4.27208 1.25 8C1.25 11.7279 4.27208 14.75 8 14.75ZM9.64999 5.64303C9.84525 5.44777 10.1618 5.44777 10.3571 5.64303C10.5524 5.83829 10.5524 6.15487 10.3571 6.35014L8.70718 8.00005L10.3571 9.64997C10.5524 9.84523 10.5524 10.1618 10.3571 10.3571C10.1618 10.5523 9.84525 10.5523 9.64999 10.3571L8.00007 8.70716L6.35016 10.3571C6.15489 10.5523 5.83831 10.5523 5.64305 10.3571C5.44779 10.1618 5.44779 9.84523 5.64305 9.64997L7.29296 8.00005L5.64305 6.35014C5.44779 6.15487 5.44779 5.83829 5.64305 5.64303C5.83831 5.44777 6.15489 5.44777 6.35016 5.64303L8.00007 7.29294L9.64999 5.64303Z" fill="#C9CCD0"></path>
                                                  </svg>
                                              </div>
                                          </div>
                                          <div class="nav-search-btn">
                                              <svg width="17" height="17" viewbox="0 0 17 17" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                  <path fill-rule="evenodd" clip-rule="evenodd" d="M16.3451 15.2003C16.6377 15.4915 16.4752 15.772 16.1934 16.0632C16.15 16.1279 16.0958 16.1818 16.0525 16.2249C15.7707 16.473 15.4456 16.624 15.1854 16.3652L11.6848 12.8815C10.4709 13.8198 8.97529 14.3267 7.44714 14.3267C3.62134 14.3267 0.5 11.2314 0.5 7.41337C0.5 3.60616 3.6105 0.5 7.44714 0.5C11.2729 0.5 14.3943 3.59538 14.3943 7.41337C14.3943 8.98802 13.8524 10.5087 12.8661 11.7383L16.3451 15.2003ZM2.13647 7.4026C2.13647 10.3146 4.52083 12.6766 7.43624 12.6766C10.3517 12.6766 12.736 10.3146 12.736 7.4026C12.736 4.49058 10.3517 2.1286 7.43624 2.1286C4.50999 2.1286 2.13647 4.50136 2.13647 7.4026Z" fill="currentColor"></path>
                                              </svg>
                                          </div>
                                      </form>
                                      <div style="display:none;" class="search-panel">
                                      <!---->
                                      <!---->
                                      <!---->
                                      </div>
                                  </div>
                              </div>
                              <div class="mini-header-right-loading"></div>
                          </div>
                          <div class="bili-header__banner">
                              <picture class="v-img banner-img" id="bili-header-banner-img">
                                  <!--[-->
                                  <source srcset="//i1.hdslb.com/bfs/archive/721ecf6ed5ef7cf406e801216513f7f318353704.png@3840w_360h_1c.avif" type="image/avif">
                                  <source srcset="//i1.hdslb.com/bfs/archive/721ecf6ed5ef7cf406e801216513f7f318353704.png@3840w_360h_1c.webp" type="image/webp">
                                  <img src="//i1.hdslb.com/bfs/archive/721ecf6ed5ef7cf406e801216513f7f318353704.png@3840w_360h_1c" alt loading="eager" onload onerror="typeof window.imgOnError === &#39;function&#39; &amp;&amp; window.imgOnError(this)">
                                  <!--]-->
                              </picture>
                              <!---->
                              <div class="header-banner__inner">
                                  <a href="//www.bilibili.com" class="inner-logo">
                                      <img class="logo-img" alt="B站 b站" width="162" height="78" src="//i0.hdslb.com/bfs/archive/c8fd97a40bf79f03e7b76cbc87236f612caef7b2.png">
                                  </a>
                                  <!---->
                              </div>
                              <div class="taper-line"></div>
                              <!---->
                          </div>
                          <div class="bili-header__channel" data-v-577c5096>
                              <div class="channel-icons" data-v-577c5096>
                                  <!--[-->
                                  <a class="channel-icons__item" href="//t.bilibili.com" target="_blank" data-v-674f5b07>
                                      <div class="icon-bg icon-bg__dynamic" data-v-674f5b07>
                                          <svg width="22" height="23" viewbox="0 0 22 23" fill="none" xmlns="http://www.w3.org/2000/svg" class="icon-bg--icon" data-v-674f5b07>
                                              <path d="M6.41659 15.625C3.88528 15.625 1.83325 13.7782 1.83325 11.5H10.9999C10.9999 13.7782 8.94789 15.625 6.41659 15.625Z" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
                                              <path d="M15.125 16.0827C15.125 18.614 13.2782 20.666 11 20.666L11 11.4993C13.2782 11.4993 15.125 13.5514 15.125 16.0827Z" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
                                              <path d="M6.875 6.91667C6.875 9.44797 8.72183 11.5 11 11.5L11 2.33333C8.72182 2.33333 6.875 4.38536 6.875 6.91667Z" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
                                              <path d="M15.5833 7.375C13.052 7.375 11 9.22183 11 11.5H20.1667C20.1667 9.22183 18.1146 7.375 15.5833 7.375Z" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
                                          </svg>
                                      </div>
                                      <!---->
                                      <span class="icon-title" data-v-674f5b07>动态</span>
                                  </a>
                                  <a href="//www.bilibili.com/v/popular/all" target="_blank" class="channel-icons__item">
                                      <div class="icon-bg icon-bg__popular">
                                          <svg width="22" height="22" viewbox="0 0 22 22" fill="none" xmlns="http://www.w3.org/2000/svg" class="icon-bg--icon">
                                              <path fill-rule="evenodd" clip-rule="evenodd" d="M4.89054 17.272L4.89277 17.2742C6.49674 18.8782 8.66472 19.7888 10.9624 19.7888C13.2503 19.7888 15.2113 19.0539 16.6107 17.6108L16.6108 17.6108L16.6128 17.6086C18.0002 16.1345 18.7835 14.182 18.7421 12.1819C18.7852 11.3835 18.6916 9.36321 17.4088 6.75488L17.4082 6.7537C17.209 6.35523 16.8163 6.06598 16.3391 5.96993C15.8904 5.87103 15.4021 6.01997 15.061 6.35741C14.9094 6.48781 14.7796 6.61755 14.6655 6.7317L14.6637 6.73348L14.6329 6.76426C14.2107 3.35588 12.6083 1.7368 11.1654 1.00465C11.148 0.987812 11.1265 0.967972 11.1036 0.950782C11.0775 0.931205 11.0311 0.900467 10.9694 0.888912C10.2276 0.608301 9.41043 1.01168 9.1237 1.77629L9.12314 1.7778C8.50566 3.46558 7.35287 4.62281 6.16627 5.76704C4.51756 7.33121 2.75938 9.03623 2.80163 12.093C2.75906 14.055 3.54464 15.8826 4.89054 17.272ZM3.04999 13.0648C3.01092 12.7459 2.99439 12.4218 3.00168 12.0939C2.95933 9.12977 4.6531 7.47834 6.30453 5.9116C7.49017 4.76831 8.67581 3.58267 9.31098 1.84655C9.56504 1.16904 10.2849 0.830288 10.9201 1.08435C10.9624 1.08435 11.0048 1.1267 11.0471 1.16904C11.9267 1.60884 12.8853 2.39635 13.5753 3.77299C12.8853 2.39633 11.9267 1.6088 11.0471 1.16901C11.0047 1.12666 10.9624 1.08432 10.9201 1.08432C10.2849 0.830251 9.56503 1.16901 9.31097 1.84651C8.6758 3.58263 7.49016 4.76827 6.30452 5.91157C4.65309 7.47831 2.95932 9.12973 3.00166 12.0938C2.99438 12.4218 3.01092 12.7459 3.04999 13.0648ZM14.477 7.18189C14.477 7.1819 14.477 7.18192 14.477 7.18193C14.5828 7.09724 14.6887 6.99138 14.8052 6.87493C14.9216 6.75849 15.0486 6.63146 15.1968 6.50442C15.4932 6.20801 15.9167 6.08098 16.2978 6.16567C16.7212 6.25036 17.06 6.50443 17.2294 6.84318C17.3088 7.0046 17.3835 7.16371 17.4539 7.32035C17.3835 7.1637 17.3087 7.00458 17.2294 6.84314C17.06 6.50439 16.7212 6.25032 16.2978 6.16563C15.9167 6.08094 15.4932 6.20798 15.1968 6.50439C15.0486 6.63142 14.9216 6.75845 14.8051 6.87489L14.8051 6.8749C14.7557 6.92437 14.7081 6.97191 14.6617 7.01675C14.5988 7.07745 14.5379 7.13318 14.477 7.18189ZM12.6977 6.35925C12.8428 7.15476 12.8833 7.97963 12.8679 8.74864C12.8679 8.79032 12.8704 8.8315 12.8754 8.87195C12.8704 8.83151 12.8679 8.79035 12.8679 8.74867C12.8833 7.97966 12.8428 7.15478 12.6977 6.35925ZM16.7358 10.6654C16.8108 11.1478 16.8483 11.6393 16.8483 12.1362V12.1786C16.8483 13.703 16.2978 15.2274 15.2392 16.3283C14.0535 17.4293 12.5291 18.0221 10.9201 17.9374C9.1416 17.9374 7.44783 17.2175 6.21984 15.9472C5.82743 15.5548 5.50448 15.1119 5.25584 14.6331C5.50447 15.1119 5.82743 15.5548 6.21983 15.9472C7.44782 17.2175 9.14159 17.9373 10.9201 17.9373C12.5291 18.022 14.0535 17.4292 15.2392 16.3283C16.2978 15.2273 16.8483 13.7029 16.8483 12.1785V12.1362C16.8483 11.6393 16.8108 11.1478 16.7358 10.6654ZM10.9306 17.7376C12.4802 17.8192 13.9509 17.2497 15.0989 16.1856C16.1154 15.1261 16.6483 13.655 16.6483 12.1785V12.1362C16.6483 10.8624 16.3969 9.6266 15.8955 8.49474C15.2436 9.11663 14.7845 9.49093 14.4179 9.68717C14.2122 9.79725 14.0268 9.85633 13.846 9.86789C13.6644 9.8795 13.5028 9.84219 13.3473 9.78249C12.9207 9.62211 12.6679 9.20129 12.6679 8.74864V8.74464L12.6679 8.74464C12.6889 7.69735 12.6046 6.55594 12.2954 5.53554C12.01 4.59379 11.5372 3.76766 10.7904 3.20655C9.96581 4.94926 8.72521 6.18561 7.58695 7.28323L7.50836 7.35967C5.97191 8.85397 4.81321 9.98087 4.85306 12.1325L4.85313 12.1362H4.85309C4.85309 13.5239 5.38326 14.8277 6.36125 15.8057L6.36365 15.8081L6.36363 15.8082C7.55387 17.0394 9.19573 17.7374 10.9201 17.7374H10.9306L10.9306 17.7376Z" fill="#ffffff"></path>
                                          </svg>
                                      </div>
                                      <span class="icon-title">热门</span>
                                  </a>
                                  <!--]-->
                              </div>
                              <div class="right-channel-container" data-v-577c5096>
                                  <div class="channel-items__left">
                                      <!--[-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/anime/" style="letter-spacing:2px;" target="_blank">番剧</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/movie/" style="letter-spacing:2px;" target="_blank">电影</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/guochuang/" style="letter-spacing:2px;" target="_blank">国创</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/tv/" style="letter-spacing:2px;" target="_blank">电视剧</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/variety/" style="letter-spacing:2px;" target="_blank">综艺</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/documentary/" style="letter-spacing:2px;" target="_blank">纪录片</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/douga/" style="letter-spacing:2px;" target="_blank">动画</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/game/" style="letter-spacing:2px;" target="_blank">游戏</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/kichiku/" style="letter-spacing:2px;" target="_blank">鬼畜</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/music" style="letter-spacing:2px;" target="_blank">音乐</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/dance/" style="letter-spacing:2px;" target="_blank">舞蹈</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/cinephile" style="letter-spacing:2px;" target="_blank">影视</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/ent/" style="letter-spacing:2px;" target="_blank">娱乐</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/knowledge/" style="letter-spacing:2px;" target="_blank">知识</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/tech/" style="letter-spacing:2px;" target="_blank">科技</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/information/" style="letter-spacing:2px;" target="_blank">资讯</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/food" style="letter-spacing:2px;" target="_blank">美食</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/life" style="letter-spacing:2px;" target="_blank">生活</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/car" style="letter-spacing:2px;" target="_blank">汽车</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/fashion" style="letter-spacing:2px;" target="_blank">时尚</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/sports" style="letter-spacing:2px;" target="_blank">运动</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/animal" style="letter-spacing:2px;" target="_blank">动物圈</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/life/daily/#/530003" style="letter-spacing:0px;" target="_blank">VLOG</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/life/funny" style="letter-spacing:2px;" target="_blank">搞笑</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/game/stand_alone" style="letter-spacing:0px;" target="_blank">单机游戏</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/v/virtual" style="letter-spacing:0px;" target="_blank">虚拟UP主</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//love.bilibili.com" style="letter-spacing:2px;" target="_blank">公益</a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link" href="//www.bilibili.com/mooc" style="letter-spacing:2px;" target="_blank">公开课</a>
                                      <!---->
                                      <!--]-->
                                      <!--]-->
                                      <!--[-->
                                      <div id="channel-entry-more" class="channel-entry-more__link">
                                          <span>更多</span>
                                          <svg width="10" height="10" viewbox="0 0 9 9" fill="none" xmlns="http://www.w3.org/2000/svg" class="channel-entry-more__link--arrow">
                                              <path fill-rule="evenodd" clip-rule="evenodd" d="M7.50588 3.40623C7.40825 3.3086 7.24996 3.3086 7.15232 3.40623L4.41244 6.14612L1.67255 3.40623C1.57491 3.3086 1.41662 3.3086 1.31899 3.40623C1.22136 3.50386 1.22136 3.66215 1.31899 3.75978L4.11781 6.5586C4.28053 6.72132 4.54434 6.72132 4.70706 6.5586L7.50588 3.75978C7.60351 3.66215 7.60351 3.50386 7.50588 3.40623Z" fill="currentColor"></path>
                                              <path d="M7.15232 3.40623L7.50588 3.75978L7.50588 3.75978L7.15232 3.40623ZM7.50588 3.40623L7.15232 3.75978L7.15233 3.75978L7.50588 3.40623ZM4.41244 6.14612L4.05888 6.49967C4.15265 6.59344 4.27983 6.64612 4.41244 6.64612C4.54504 6.64612 4.67222 6.59344 4.76599 6.49967L4.41244 6.14612ZM1.67255 3.40623L2.0261 3.05268L2.0261 3.05268L1.67255 3.40623ZM1.31899 3.40623L0.965439 3.05268L0.965439 3.05268L1.31899 3.40623ZM1.31899 3.75978L1.67255 3.40623V3.40623L1.31899 3.75978ZM4.11781 6.5586L3.76425 6.91215L4.11781 6.5586ZM4.70706 6.5586L4.35351 6.20505L4.70706 6.5586ZM7.50588 3.75978L7.15233 3.40623L7.15232 3.40623L7.50588 3.75978ZM7.50588 3.75978C7.40825 3.85742 7.24996 3.85742 7.15232 3.75978L7.85943 3.05268C7.56654 2.75978 7.09166 2.75978 6.79877 3.05268L7.50588 3.75978ZM4.76599 6.49967L7.50588 3.75978L6.79877 3.05268L4.05888 5.79257L4.76599 6.49967ZM1.31899 3.75978L4.05888 6.49967L4.76599 5.79257L2.0261 3.05268L1.31899 3.75978ZM1.67254 3.75979C1.57491 3.85742 1.41662 3.85742 1.31899 3.75979L2.0261 3.05268C1.73321 2.75978 1.25833 2.75978 0.965439 3.05268L1.67254 3.75979ZM1.67255 3.40623C1.77018 3.50386 1.77018 3.66215 1.67255 3.75978L0.965439 3.05268C0.672546 3.34557 0.672546 3.82044 0.965439 4.11334L1.67255 3.40623ZM4.47136 6.20505L1.67255 3.40623L0.965439 4.11334L3.76425 6.91215L4.47136 6.20505ZM4.35351 6.20505C4.38605 6.1725 4.43882 6.1725 4.47136 6.20505L3.76425 6.91215C4.12223 7.27013 4.70264 7.27013 5.06062 6.91215L4.35351 6.20505ZM7.15232 3.40623L4.35351 6.20505L5.06062 6.91215L7.85943 4.11334L7.15232 3.40623ZM7.15233 3.75978C7.05469 3.66215 7.05469 3.50386 7.15233 3.40623L7.85943 4.11334C8.15233 3.82045 8.15233 3.34557 7.85943 3.05268L7.15233 3.75978Z" fill="currentColor"></path>
                                          </svg>
                                      </div>
                                      <!---->
                                      <!--]-->
                                  </div>
                                  <div class="channel-items__right">
                                      <!--[-->
                                      <!--[-->
                                      <a class="channel-link__right" href="//www.bilibili.com/read/home" style="letter-spacing:2px;" target="_blank">
                                          <svg t="1642646834655" class="icon side-icon" viewbox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4061" width="200" height="200">
                                              <path d="M810.6496 153.6C843.6736 153.6 870.4 180.3264 870.4 213.3504v597.2992c0 33.024-26.7264 59.7504-59.7504 59.7504H213.3504A59.7504 59.7504 0 0 1 153.6 810.6496V213.3504C153.6 180.3264 180.3264 153.6 213.3504 153.6z m-332.8 460.8H341.3504a34.1504 34.1504 0 0 0 0 68.2496h136.4992a34.1504 34.1504 0 1 0 0-68.2496z m204.8-136.6016H341.3504a34.1504 34.1504 0 0 0 0 68.2496h341.2992a34.1504 34.1504 0 0 0 0-68.2496z m0-136.3968H341.3504a34.1504 34.1504 0 0 0 0 68.2496h341.2992a34.1504 34.1504 0 1 0 0-68.2496z" p-id="4062"></path>
                                          </svg>
                                          <span>专栏</span>
                                      </a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link__right" href="//live.bilibili.com" style="letter-spacing:2px;" target="_blank">
                                          <svg t="1642646710703" class="icon side-icon" viewbox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3158" width="200" height="200">
                                              <path d="M682.6496 204.8512c35.4816 0 64.6656 27.136 67.9424 61.696l0.3072 6.6048V358.4l81.92-61.44a34.2016 34.2016 0 0 1 53.248 17.408l1.024 4.7616 0.3584 5.12v392.5504a34.1504 34.1504 0 0 1-50.2784 30.1056l-4.352-2.7648-81.92-61.4912v68.3008c0 33.1264-23.552 60.7232-54.8352 66.9696l-6.8608 1.024-6.5536 0.256H204.8a68.2496 68.2496 0 0 1-67.9936-61.696l-0.3072-6.5536V273.152c0-35.4816 27.136-64.6656 61.696-67.9936L204.8 204.8512h477.8496zM385.3824 389.12a34.1504 34.1504 0 0 0-34.0992 34.1504v179.6096a34.1504 34.1504 0 0 0 53.0432 28.416l134.7584-89.8048a34.1504 34.1504 0 0 0 0-56.832L404.3264 394.8544a34.1504 34.1504 0 0 0-18.944-5.7344z" p-id="3159"></path>
                                          </svg>
                                          <span>直播</span>
                                      </a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link__right" href="//www.bilibili.com/blackboard/activity-list.html?" style="letter-spacing:2px;" target="_blank">
                                          <svg t="1642646844599" class="icon side-icon" viewbox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4188" width="200" height="200">
                                              <path d="M772.4544 229.2736l2.048 6.4512 87.2448 283.136c8.8576 33.1264-10.24 66.56-41.984 78.4384l-6.5536 2.048-118.1696 31.744a32.768 32.768 0 0 1-8.192 1.0752l-4.096-0.2048-124.672-14.6432-193.3824 51.8144 36.6592 136.704a49.152 49.152 0 0 1-93.184 30.8736l-1.792-5.4272L155.2896 267.264a49.152 49.152 0 0 1 93.184-30.8736l1.792 5.4272 4.096 15.36 188.928-50.6368a32.768 32.768 0 0 1 8.1408-1.0752l4.096 0.2048 124.5184 14.592 112.1792-30.0544c33.4336-8.96 68.1984 7.7824 80.2304 39.0144z" p-id="4189"></path>
                                          </svg>
                                          <span>活动</span>
                                      </a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link__right" href="//www.bilibili.com/cheese/?csource=common_hp_channelclass_icon" style="letter-spacing:2px;" target="_blank">
                                          <svg t="1642669966795" class="icon side-icon" viewbox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2862" width="200" height="200">
                                              <path d="M749.2096 168.96a102.4 102.4 0 0 1 102.2464 96.3584l0.1536 6.0416v477.8496a102.4 102.4 0 0 1-96.3584 102.2464l-6.0416 0.1536H271.36a102.4 102.4 0 0 1-102.2464-96.3584l-0.1536-6.0416V271.36a102.4 102.4 0 0 1 96.3584-102.2464L271.36 168.96h477.8496z m-69.9392 385.4848a34.1504 34.1504 0 0 0-48.2816 0 170.6496 170.6496 0 0 1-241.3568 0 34.1504 34.1504 0 1 0-48.2816 48.2304 238.9504 238.9504 0 0 0 337.92 0 34.1504 34.1504 0 0 0 0-48.2304zM322.56 339.6608a51.2 51.2 0 0 0-51.2 51.2v34.1504a51.2 51.2 0 1 0 102.4 0v-34.1504a51.2 51.2 0 0 0-51.2-51.2z m375.4496 0a51.2 51.2 0 0 0-51.2 51.2v34.1504a51.2 51.2 0 1 0 102.4 0v-34.1504a51.2 51.2 0 0 0-51.2-51.2z" p-id="2863"></path>
                                          </svg>
                                          <span>课堂</span>
                                      </a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link__right" href="https://www.bilibili.com/blackboard/activity-5zJxM3spoS.html" style="letter-spacing:0px;" target="_blank">
                                          <svg t="1642670011510" class="icon side-icon" viewbox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3116" width="200" height="200">
                                              <path d="M836.3008 170.6496c17.1008 0 31.2832 12.6464 33.7408 29.0816L870.4 204.8v316.16a34.1504 34.1504 0 0 1-29.0816 33.792l-5.0176 0.3584h-102.4v195.7888a34.1504 34.1504 0 0 1-29.1328 33.792l-5.0176 0.3584H386.7648l-127.3344 95.5392a34.2016 34.2016 0 0 1-53.248-17.3568l-1.024-4.8128-0.3584-5.12-0.0512-68.3008H153.6a34.1504 34.1504 0 0 1-32.6656-24.2176l-1.0752-4.8128-0.4096-5.0688v-409.6c0-17.152 12.6464-31.3344 29.0816-33.792L153.6 307.2h174.2336V204.8c0-17.152 12.6464-31.3344 29.1328-33.792l5.0176-0.3584h474.3168z m-477.9008 409.6H256l-5.0688 0.4096a34.1504 34.1504 0 0 0 0 67.4816l5.0688 0.4096h102.4l5.0688-0.4096A34.1504 34.1504 0 0 0 358.4 580.2496z m102.4-136.4992H256l-5.0688 0.4096a34.1504 34.1504 0 0 0 0 67.4816l5.0688 0.4096h204.8l5.0688-0.4096A34.1504 34.1504 0 0 0 460.8 443.7504z m341.2992-204.8512h-406.016v68.2496h303.616c17.152 0 31.3856 12.6464 33.792 29.1328l0.3584 5.0176v145.4592l68.2496 0.0512V238.8992z" p-id="3117"></path>
                                          </svg>
                                          <span>社区中心</span>
                                      </a>
                                      <!---->
                                      <!--]-->
                                      <!--[-->
                                      <a class="channel-link__right" href="//music.bilibili.com/pc/music-center/" style="letter-spacing:0px;" target="_blank">
                                          <svg t="1642669999866" class="icon side-icon" viewbox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2989" width="200" height="200">
                                              <path d="M783.36 221.8496a102.4 102.4 0 0 1 102.0928 94.7712l0.3072 7.68v409.6a102.4 102.4 0 0 1-94.72 102.0928l-7.68 0.256H237.2096a102.4 102.4 0 0 1-102.0928-94.72l-0.3072-7.68v-409.6A102.4 102.4 0 0 1 229.5808 222.208l7.68-0.3072H783.36z m-155.5968 81.408a34.1504 34.1504 0 0 0-50.7904 23.6032l-54.1696 203.3152a128 128 0 1 0-108.288 220.8256l6.7584 1.024a128 128 0 0 0 141.5168-104.8576l71.7824-253.7984 47.4624 35.4816 3.2768 2.2016a34.1504 34.1504 0 0 0 37.5808-56.832l-91.8528-68.7616z" p-id="2990"></path>
                                          </svg>
                                          <span>新歌热榜</span>
                                      </a>
                                      <!---->
                                      <!--]-->
                                      <!--]-->
                                  </div>
                              </div>
                          </div>
                          <!---->
                      </div>
                      <!---->
                      <!---->
                      <!--]-->
                      <!---->
                      <!---->
                      <main class="bili-feed4-layout">
                          <div class="fixed-channel-shim"></div>
                          <div class="feed2">
                              <!--[-->
                              <div class="recommended-container_floor-aside" data-v-3badd762>
                                  <div class="container is-version8" data-v-3badd762>
                                      <div class="recommended-swipe grid-anchor" data-loc-id="4694" style="--cover-radio:56.25%;" data-v-3badd762>
                                          <div class="recommended-swipe-core">
                                              <div class="recommended-swipe-shim">
                                                  <div class="bili-video-card" style="--cover-radio:56.25%;" data-report>
                                                      <div class="bili-video-card__skeleton">
                                                          <div class="bili-video-card__skeleton--cover"></div>
                                                          <div class="bili-video-card__skeleton--info">
                                                              <div class="bili-video-card__skeleton--right">
                                                                  <p class="bili-video-card__skeleton--text"></p>
                                                                  <p class="bili-video-card__skeleton--text short"></p>
                                                                  <p class="bili-video-card__skeleton--light"></p>
                                                              </div>
                                                          </div>
                                                      </div>
                                                      <!---->
                                                  </div>
                                                  <div class="bili-video-card" style="--cover-radio:56.25%;" data-report>
                                                      <div class="bili-video-card__skeleton">
                                                          <div class="bili-video-card__skeleton--cover"></div>
                                                          <div class="bili-video-card__skeleton--info">
                                                              <div class="bili-video-card__skeleton--right">
                                                                  <p class="bili-video-card__skeleton--text"></p>
                                                                  <p class="bili-video-card__skeleton--text short"></p>
                                                                  <p class="bili-video-card__skeleton--light"></p>
                                                              </div>
                                                          </div>
                                                      </div>
                                                      <!---->
                                                  </div>
                                                  <div class="shim-card"></div>
                                                  <div class="shim-card"></div>
                                              </div>
                                              <div class="recommended-swipe-body">
                                                  <!--[-->
                                                  <!--[-->
                                                  <!--]-->
                                                  <!--[-->
                                                  <!--[-->
                                                  <div class="carousel-area">
                                                      <div class="carousel" data-v-3f80e0b0>
                                                          <div class="carousel-container" style="overflow-x:hidden;height:;overflow-y:;width:100%;" data-v-3f80e0b0>
                                                              <!--[-->
                                                              <!--[-->
                                                              <!---->
                                                              <!---->
                                                              <!---->
                                                              <!---->
                                                              <!---->
                                                              <!---->
                                                              <!---->
                                                              <!---->
                                                              <!---->
                                                              <!--]-->
                                                              <!--]-->
                                                              <div style="" class="carousel-transform clearfix" data-v-3f80e0b0>
                                                              <!--[-->
                                                              <!--]-->
                                                              </div>
                                                              <div class="carousel-footer" data-v-3f80e0b0>
                                                                  <!--[-->
                                                                  <div class="carousel-mask" style="background-color:#3d2111;"></div>
                                                                  <div class="carousel-tool not-gray" data-gray="39" style="color:white;">
                                                                      <a href="https://www.bilibili.com/blackboard/bnj2024.html?auto_media_playback=1&amp;msource=sz" target="_blank">
                                                                          <span>2024哔哩哔哩拜年纪火热预约中！</span>
                                                                      </a>
                                                                      <ul class="not-gray">
                                                                          <!--[-->
                                                                          <li class="is-active">
                                                                              <div class="before"></div>
                                                                              <div class="after"></div>
                                                                          </li>
                                                                          <li class="">
                                                                              <div class="before"></div>
                                                                              <div class="after"></div>
                                                                          </li>
                                                                          <li class="">
                                                                              <div class="before"></div>
                                                                              <div class="after"></div>
                                                                          </li>
                                                                          <li class="">
                                                                              <div class="before"></div>
                                                                              <div class="after"></div>
                                                                          </li>
                                                                          <li class="">
                                                                              <div class="before"></div>
                                                                              <div class="after"></div>
                                                                          </li>
                                                                          <li class="">
                                                                              <div class="before"></div>
                                                                              <div class="after"></div>
                                                                          </li>
                                                                          <li class="">
                                                                              <div class="before"></div>
                                                                              <div class="after"></div>
                                                                          </li>
                                                                          <li class="">
                                                                              <div class="before"></div>
                                                                              <div class="after"></div>
                                                                          </li>
                                                                          <li class="">
                                                                              <div class="before"></div>
                                                                              <div class="after"></div>
                                                                          </li>
                                                                          <!--]-->
                                                                      </ul>
                                                                  </div>
                                                                  <div class="buttons not-gray">
                                                                      <!---->
                                                                      <div>
                                                                          <button>
                                                                              <svg style="transform:rotate(180deg);">
                                                                                  <use xlink:href="#widget-arrow"></use>
                                                                              </svg>
                                                                          </button>
                                                                          <button>
                                                                              <svg>
                                                                                  <use xlink:href="#widget-arrow"></use>
                                                                              </svg>
                                                                          </button>
                                                                      </div>
                                                                  </div>
                                                                  <!--]-->
                                                              </div>
                                                          </div>
                                                      </div>
                                                  </div>
                                                  <!--]-->
                                                  <!--]-->
                                                  <!--[-->
                                                  <!--]-->
                                                  <!---->
                                                  <!--[-->
                                                  <!---->
                                                  <!--]-->
                                                  <!--]-->
                                              </div>
                                          </div>
                                      </div>
                                      <!--[-->
                                      <!--[-->
                                      <!--[-->
                                      <div class="feed-card" data-v-3badd762>
                                          <div class="bili-video-card is-rcmd" style="--cover-radio:56.25%;" data-report="tianma.1-1-1.click" data-v-3badd762>
                                              <div class="bili-video-card__skeleton hide">
                                                  <div class="bili-video-card__skeleton--cover"></div>
                                                  <div class="bili-video-card__skeleton--info">
                                                      <div class="bili-video-card__skeleton--right">
                                                          <p class="bili-video-card__skeleton--text"></p>
                                                          <p class="bili-video-card__skeleton--text short"></p>
                                                          <p class="bili-video-card__skeleton--light"></p>
                                                      </div>
                                                  </div>
                                              </div>
                                              <div class="bili-video-card__wrap __scale-wrap">
                                                  <!---->
                                                  <a class="bili-video-card__image--link" href="https://www.bilibili.com/video/BV1U94y1u77T" target="_blank">
                                                      <div class="bili-video-card__image __scale-player-wrap bili-video-card__image--hover">
                                                          <div class="bili-video-card__image--wrap">
                                                              <!---->
                                                              <picture class="v-img bili-video-card__cover">
                                                                  <!--[-->
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/8afeca095852e09a27f4582a68eec80f4b92d509.jpg@672w_378h_1c_!web-home-common-cover.avif" type="image/avif">
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/8afeca095852e09a27f4582a68eec80f4b92d509.jpg@672w_378h_1c_!web-home-common-cover.webp" type="image/webp">
                                                                  <img src="//i1.hdslb.com/bfs/archive/8afeca095852e09a27f4582a68eec80f4b92d509.jpg@672w_378h_1c_!web-home-common-cover" alt="2023年度 - 编程相关书籍回顾与推荐" loading="eager" onload onerror="typeof window.imgOnError === &#39;function&#39; &amp;&amp; window.imgOnError(this)">
                                                                  <!--]-->
                                                              </picture>
                                                          </div>
                                                          <div class="bili-video-card__mask">
                                                              <div class="bili-video-card__stats">
                                                                  <div class="bili-video-card__stats--left">
                                                                      <!--[-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">9592</span>
                                                                      </span>
                                                                      <!--]-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">9</span>
                                                                      </span>
                                                                  </div>
                                                                  <span class="bili-video-card__stats__duration">14:34</span>
                                                              </div>
                                                          </div>
                                                      </div>
                                                  </a>
                                                  <div style="" class="bili-video-card__info __scale-disable">
                                                      <!--[-->
                                                      <!---->
                                                      <!--]-->
                                                      <div class="bili-video-card__info--right">
                                                          <!---->
                                                          <h3 class="bili-video-card__info--tit" title="2023年度 - 编程相关书籍回顾与推荐">
                                                              <a href="https://www.bilibili.com/video/BV1U94y1u77T" target="_blank">2023年度 - 编程相关书籍回顾与推荐</a>
                                                          </h3>
                                                          <div class="bili-video-card__info--bottom">
                                                              <div class="bili-video-card__info--icon-text">已关注</div>
                                                              <!--[-->
                                                              <a class="bili-video-card__info--owner" href="//space.bilibili.com/480804525" target="_blank">
                                                                  <!---->
                                                                  <span class="bili-video-card__info--author" title="__阿岳__">__阿岳__</span>
                                                                  <span class="bili-video-card__info--date">· 2023-12-30</span>
                                                              </a>
                                                              <!--]-->
                                                          </div>
                                                      </div>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                      <div class="feed-card" data-v-3badd762>
                                          <div class="bili-video-card is-rcmd" style="--cover-radio:56.25%;" data-report="tianma.1-2-2.click" data-v-3badd762>
                                              <div class="bili-video-card__skeleton hide">
                                                  <div class="bili-video-card__skeleton--cover"></div>
                                                  <div class="bili-video-card__skeleton--info">
                                                      <div class="bili-video-card__skeleton--right">
                                                          <p class="bili-video-card__skeleton--text"></p>
                                                          <p class="bili-video-card__skeleton--text short"></p>
                                                          <p class="bili-video-card__skeleton--light"></p>
                                                      </div>
                                                  </div>
                                              </div>
                                              <div class="bili-video-card__wrap __scale-wrap">
                                                  <!---->
                                                  <a class="bili-video-card__image--link" href="https://www.bilibili.com/video/BV1ie411o79T" target="_blank">
                                                      <div class="bili-video-card__image __scale-player-wrap bili-video-card__image--hover">
                                                          <div class="bili-video-card__image--wrap">
                                                              <!---->
                                                              <picture class="v-img bili-video-card__cover">
                                                                  <!--[-->
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/f701e95d15811acc36629d1ba158ed6b085efa2e.jpg@672w_378h_1c_!web-home-common-cover.avif" type="image/avif">
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/f701e95d15811acc36629d1ba158ed6b085efa2e.jpg@672w_378h_1c_!web-home-common-cover.webp" type="image/webp">
                                                                  <img src="//i1.hdslb.com/bfs/archive/f701e95d15811acc36629d1ba158ed6b085efa2e.jpg@672w_378h_1c_!web-home-common-cover" alt="【王维MBTI】16型人格的情感需求｜部分cp向｜全员向动画" loading="eager" onload="fsrCb()" onerror="typeof window.imgOnError === &#39;function&#39; &amp;&amp; window.imgOnError(this)">
                                                                  <!--]-->
                                                              </picture>
                                                          </div>
                                                          <div class="bili-video-card__mask">
                                                              <div class="bili-video-card__stats">
                                                                  <div class="bili-video-card__stats--left">
                                                                      <!--[-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">47万</span>
                                                                      </span>
                                                                      <!--]-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">5934</span>
                                                                      </span>
                                                                  </div>
                                                                  <span class="bili-video-card__stats__duration">18:56</span>
                                                              </div>
                                                          </div>
                                                      </div>
                                                  </a>
                                                  <div style="" class="bili-video-card__info __scale-disable">
                                                      <!--[-->
                                                      <!---->
                                                      <!--]-->
                                                      <div class="bili-video-card__info--right">
                                                          <!---->
                                                          <h3 class="bili-video-card__info--tit" title="【王维MBTI】16型人格的情感需求｜部分cp向｜全员向动画">
                                                              <a href="https://www.bilibili.com/video/BV1ie411o79T" target="_blank">【王维MBTI】16型人格的情感需求｜部分cp向｜全员向动画</a>
                                                          </h3>
                                                          <div class="bili-video-card__info--bottom">
                                                              <div class="bili-video-card__info--icon-text">3万点赞</div>
                                                              <!--[-->
                                                              <a class="bili-video-card__info--owner" href="//space.bilibili.com/3493079208168355" target="_blank">
                                                                  <!---->
                                                                  <span class="bili-video-card__info--author" title="王维诗里的MBTI">王维诗里的MBTI</span>
                                                                  <span class="bili-video-card__info--date">· 2023-12-10</span>
                                                              </a>
                                                              <!--]-->
                                                          </div>
                                                      </div>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                      <div class="feed-card" data-v-3badd762>
                                          <div class="bili-video-card is-rcmd" style="--cover-radio:56.25%;" data-report="tianma.1-3-3.click" data-v-3badd762>
                                              <div class="bili-video-card__skeleton hide">
                                                  <div class="bili-video-card__skeleton--cover"></div>
                                                  <div class="bili-video-card__skeleton--info">
                                                      <div class="bili-video-card__skeleton--right">
                                                          <p class="bili-video-card__skeleton--text"></p>
                                                          <p class="bili-video-card__skeleton--text short"></p>
                                                          <p class="bili-video-card__skeleton--light"></p>
                                                      </div>
                                                  </div>
                                              </div>
                                              <div class="bili-video-card__wrap __scale-wrap">
                                                  <!---->
                                                  <a class="bili-video-card__image--link" href="https://www.bilibili.com/video/BV1Pw411P7C9" target="_blank">
                                                      <div class="bili-video-card__image __scale-player-wrap bili-video-card__image--hover">
                                                          <div class="bili-video-card__image--wrap">
                                                              <!---->
                                                              <picture class="v-img bili-video-card__cover">
                                                                  <!--[-->
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/65479f1ba228b11160459bc70cfc70c08ff55729.jpg@672w_378h_1c_!web-home-common-cover.avif" type="image/avif">
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/65479f1ba228b11160459bc70cfc70c08ff55729.jpg@672w_378h_1c_!web-home-common-cover.webp" type="image/webp">
                                                                  <img src="//i1.hdslb.com/bfs/archive/65479f1ba228b11160459bc70cfc70c08ff55729.jpg@672w_378h_1c_!web-home-common-cover" alt="锐评刚满18岁事件，被性丑化的人真的很恶心" loading="eager" onload="fsrCb()" onerror="typeof window.imgOnError === &#39;function&#39; &amp;&amp; window.imgOnError(this)">
                                                                  <!--]-->
                                                              </picture>
                                                          </div>
                                                          <div class="bili-video-card__mask">
                                                              <div class="bili-video-card__stats">
                                                                  <div class="bili-video-card__stats--left">
                                                                      <!--[-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">436.1万</span>
                                                                      </span>
                                                                      <!--]-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">8183</span>
                                                                      </span>
                                                                  </div>
                                                                  <span class="bili-video-card__stats__duration">06:22</span>
                                                              </div>
                                                          </div>
                                                      </div>
                                                  </a>
                                                  <div style="" class="bili-video-card__info __scale-disable">
                                                      <!--[-->
                                                      <!---->
                                                      <!--]-->
                                                      <div class="bili-video-card__info--right">
                                                          <!---->
                                                          <h3 class="bili-video-card__info--tit" title="锐评刚满18岁事件，被性丑化的人真的很恶心">
                                                              <a href="https://www.bilibili.com/video/BV1Pw411P7C9" target="_blank">锐评刚满18岁事件，被性丑化的人真的很恶心</a>
                                                          </h3>
                                                          <div class="bili-video-card__info--bottom">
                                                              <!---->
                                                              <!--[-->
                                                              <a class="bili-video-card__info--owner" href="//space.bilibili.com/378885845" target="_blank">
                                                                  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="currentColor" class="bili-video-card__info--owner__up">
                                                                  <!--[-->
                                                                  <!--]-->
                                                                  </svg>
                                                                  <span class="bili-video-card__info--author" title="不正经老丝">不正经老丝</span>
                                                                  <span class="bili-video-card__info--date">· 2023-11-22</span>
                                                              </a>
                                                              <!--]-->
                                                          </div>
                                                      </div>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                      <div class="feed-card" data-v-3badd762>
                                          <div class="bili-video-card is-rcmd" style="--cover-radio:56.25%;" data-report="tianma.2-1-4.click" data-v-3badd762>
                                              <div class="bili-video-card__skeleton hide">
                                                  <div class="bili-video-card__skeleton--cover"></div>
                                                  <div class="bili-video-card__skeleton--info">
                                                      <div class="bili-video-card__skeleton--right">
                                                          <p class="bili-video-card__skeleton--text"></p>
                                                          <p class="bili-video-card__skeleton--text short"></p>
                                                          <p class="bili-video-card__skeleton--light"></p>
                                                      </div>
                                                  </div>
                                              </div>
                                              <div class="bili-video-card__wrap __scale-wrap">
                                                  <!---->
                                                  <a class="bili-video-card__image--link" href="https://www.bilibili.com/video/BV1uC4y1q79G" target="_blank">
                                                      <div class="bili-video-card__image __scale-player-wrap bili-video-card__image--hover">
                                                          <div class="bili-video-card__image--wrap">
                                                              <!---->
                                                              <picture class="v-img bili-video-card__cover">
                                                                  <!--[-->
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/9ac7edc74640a7fd50fecafd410cc71145fc2f2b.jpg@672w_378h_1c_!web-home-common-cover.avif" type="image/avif">
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/9ac7edc74640a7fd50fecafd410cc71145fc2f2b.jpg@672w_378h_1c_!web-home-common-cover.webp" type="image/webp">
                                                                  <img src="//i1.hdslb.com/bfs/archive/9ac7edc74640a7fd50fecafd410cc71145fc2f2b.jpg@672w_378h_1c_!web-home-common-cover" alt="【硬核】一口气了解美联储 | 全球权力最大的金融机构" loading="eager" onload onerror="typeof window.imgOnError === &#39;function&#39; &amp;&amp; window.imgOnError(this)">
                                                                  <!--]-->
                                                              </picture>
                                                          </div>
                                                          <div class="bili-video-card__mask">
                                                              <div class="bili-video-card__stats">
                                                                  <div class="bili-video-card__stats--left">
                                                                      <!--[-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">200.2万</span>
                                                                      </span>
                                                                      <!--]-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">1.2万</span>
                                                                      </span>
                                                                  </div>
                                                                  <span class="bili-video-card__stats__duration">24:23</span>
                                                              </div>
                                                          </div>
                                                      </div>
                                                  </a>
                                                  <div style="" class="bili-video-card__info __scale-disable">
                                                      <!--[-->
                                                      <!---->
                                                      <!--]-->
                                                      <div class="bili-video-card__info--right">
                                                          <!---->
                                                          <h3 class="bili-video-card__info--tit" title="【硬核】一口气了解美联储 | 全球权力最大的金融机构">
                                                              <a href="https://www.bilibili.com/video/BV1uC4y1q79G" target="_blank">【硬核】一口气了解美联储 | 全球权力最大的金融机构</a>
                                                          </h3>
                                                          <div class="bili-video-card__info--bottom">
                                                              <!---->
                                                              <!--[-->
                                                              <a class="bili-video-card__info--owner" href="//space.bilibili.com/520819684" target="_blank">
                                                                  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="currentColor" class="bili-video-card__info--owner__up">
                                                                  <!--[-->
                                                                  <!--]-->
                                                                  </svg>
                                                                  <span class="bili-video-card__info--author" title="小Lin说">小Lin说</span>
                                                                  <span class="bili-video-card__info--date">· 1-1</span>
                                                              </a>
                                                              <!--]-->
                                                          </div>
                                                      </div>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                      <div class="feed-card" data-v-3badd762>
                                          <div class="bili-video-card is-rcmd" style="--cover-radio:56.25%;" data-report="tianma.2-2-5.click" data-v-3badd762>
                                              <div class="bili-video-card__skeleton hide">
                                                  <div class="bili-video-card__skeleton--cover"></div>
                                                  <div class="bili-video-card__skeleton--info">
                                                      <div class="bili-video-card__skeleton--right">
                                                          <p class="bili-video-card__skeleton--text"></p>
                                                          <p class="bili-video-card__skeleton--text short"></p>
                                                          <p class="bili-video-card__skeleton--light"></p>
                                                      </div>
                                                  </div>
                                              </div>
                                              <div class="bili-video-card__wrap __scale-wrap">
                                                  <!---->
                                                  <a class="bili-video-card__image--link" href="https://gaoneng.bilibili.com/tetris/page/?pageId=832303904134623232&amp;pre_render_global=0&amp;auto_media_playback=1&amp;navhide=0&amp;buvid=__BUVID__&amp;mid=__MID__&amp;imei=__IMEI__&amp;duid=__DUID__&amp;idfa=__IDFA__&amp;android_id=__ANDROIDID__&amp;os=3&amp;request_id=1705300832108q172a25a163a109q2568&amp;source_id=5614&amp;track_id=pbaes.TgqHxU3OBEgtPP_gUKO4X43p3EwiASSBuepvg80FDhPy7FgA5zCLArdxkdxhK4AECABj2iLrVVtKDV-7hTTqIP4vdWkTqHcCiLC5WyqnxvGz4ss47RjrNNU5mGUiXDT3Xl7ZqDbsdiI5qyJEtGB6CGMc02GfMWpGDF5jL4aYLK1XhdUGewyQ7y0FDNGBc6jZ&amp;creative_id=121799182&amp;adtype=CPC" target="_blank">
                                                      <div class="bili-video-card__image __scale-player-wrap bili-video-card__image--hover">
                                                          <div class="bili-video-card__image--wrap">
                                                              <!---->
                                                              <picture class="v-img bili-video-card__cover">
                                                                  <!--[-->
                                                                  <source srcset="//i1.hdslb.com/bfs/sycp/creative_img/202311/a4d44b79f9b4aa088fdac4aaf18fee69.jpg@672w_378h_1c_!web-home-common-cover.avif" type="image/avif">
                                                                  <source srcset="//i1.hdslb.com/bfs/sycp/creative_img/202311/a4d44b79f9b4aa088fdac4aaf18fee69.jpg@672w_378h_1c_!web-home-common-cover.webp" type="image/webp">
                                                                  <img src="//i1.hdslb.com/bfs/sycp/creative_img/202311/a4d44b79f9b4aa088fdac4aaf18fee69.jpg@672w_378h_1c_!web-home-common-cover" alt="互动，测一测留学生回国薪资能有多少？" loading="eager" onload="fsrCb()" onerror="typeof window.imgOnError === &#39;function&#39; &amp;&amp; window.imgOnError(this)">
                                                                  <!--]-->
                                                              </picture>
                                                          </div>
                                                          <div class="bili-video-card__mask">
                                                          <!---->
                                                          </div>
                                                      </div>
                                                  </a>
                                                  <div style="" class="bili-video-card__info __scale-disable">
                                                      <!--[-->
                                                      <!---->
                                                      <!--]-->
                                                      <div class="bili-video-card__info--right">
                                                          <!---->
                                                          <h3 class="bili-video-card__info--tit" title="互动，测一测留学生回国薪资能有多少？">
                                                              <a href="https://gaoneng.bilibili.com/tetris/page/?pageId=832303904134623232&amp;pre_render_global=0&amp;auto_media_playback=1&amp;navhide=0&amp;buvid=__BUVID__&amp;mid=__MID__&amp;imei=__IMEI__&amp;duid=__DUID__&amp;idfa=__IDFA__&amp;android_id=__ANDROIDID__&amp;os=3&amp;request_id=1705300832108q172a25a163a109q2568&amp;source_id=5614&amp;track_id=pbaes.TgqHxU3OBEgtPP_gUKO4X43p3EwiASSBuepvg80FDhPy7FgA5zCLArdxkdxhK4AECABj2iLrVVtKDV-7hTTqIP4vdWkTqHcCiLC5WyqnxvGz4ss47RjrNNU5mGUiXDT3Xl7ZqDbsdiI5qyJEtGB6CGMc02GfMWpGDF5jL4aYLK1XhdUGewyQ7y0FDNGBc6jZ&amp;creative_id=121799182&amp;adtype=CPC" target="_blank">互动，测一测留学生回国薪资能有多少？</a>
                                                          </h3>
                                                          <div class="bili-video-card__info--bottom">
                                                              <!---->
                                                              <!--[-->
                                                              <a class="bili-video-card__info--owner disable-hover" href="https://gaoneng.bilibili.com/tetris/page/?pageId=832303904134623232&amp;pre_render_global=0&amp;auto_media_playback=1&amp;navhide=0&amp;buvid=__BUVID__&amp;mid=__MID__&amp;imei=__IMEI__&amp;duid=__DUID__&amp;idfa=__IDFA__&amp;android_id=__ANDROIDID__&amp;os=3&amp;request_id=1705300832108q172a25a163a109q2568&amp;source_id=5614&amp;track_id=pbaes.TgqHxU3OBEgtPP_gUKO4X43p3EwiASSBuepvg80FDhPy7FgA5zCLArdxkdxhK4AECABj2iLrVVtKDV-7hTTqIP4vdWkTqHcCiLC5WyqnxvGz4ss47RjrNNU5mGUiXDT3Xl7ZqDbsdiI5qyJEtGB6CGMc02GfMWpGDF5jL4aYLK1XhdUGewyQ7y0FDNGBc6jZ&amp;creative_id=121799182&amp;adtype=CPC" target="_blank">
                                                                  <!---->
                                                                  <svg class="bili-video-card__info--ad">
                                                                      <use xlink:href="#palette-ad"></use>
                                                                  </svg>
                                                                  <span class="bili-video-card__info--author" title="TogoCareer">TogoCareer</span>
                                                              </a>
                                                              <!--]-->
                                                          </div>
                                                      </div>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                      <div class="feed-card" data-v-3badd762>
                                          <div class="bili-video-card is-rcmd" style="--cover-radio:56.25%;" data-report="tianma.2-3-6.click" data-v-3badd762>
                                              <div class="bili-video-card__skeleton hide">
                                                  <div class="bili-video-card__skeleton--cover"></div>
                                                  <div class="bili-video-card__skeleton--info">
                                                      <div class="bili-video-card__skeleton--right">
                                                          <p class="bili-video-card__skeleton--text"></p>
                                                          <p class="bili-video-card__skeleton--text short"></p>
                                                          <p class="bili-video-card__skeleton--light"></p>
                                                      </div>
                                                  </div>
                                              </div>
                                              <div class="bili-video-card__wrap __scale-wrap">
                                                  <!---->
                                                  <a class="bili-video-card__image--link" href="https://www.bilibili.com/video/BV1f94y1u7ti" target="_blank">
                                                      <div class="bili-video-card__image __scale-player-wrap bili-video-card__image--hover">
                                                          <div class="bili-video-card__image--wrap">
                                                              <!---->
                                                              <picture class="v-img bili-video-card__cover">
                                                                  <!--[-->
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/e0d9c7ef28a0db2b94c9d28fb322aacfe5480d27.jpg@672w_378h_1c_!web-home-common-cover.avif" type="image/avif">
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/e0d9c7ef28a0db2b94c9d28fb322aacfe5480d27.jpg@672w_378h_1c_!web-home-common-cover.webp" type="image/webp">
                                                                  <img src="//i1.hdslb.com/bfs/archive/e0d9c7ef28a0db2b94c9d28fb322aacfe5480d27.jpg@672w_378h_1c_!web-home-common-cover" alt="谨以此片献给每一位热爱原神的玩家！【耗时𝟏年高质量努力制作】" loading="eager" onload="fsrCb()" onerror="typeof window.imgOnError === &#39;function&#39; &amp;&amp; window.imgOnError(this)">
                                                                  <!--]-->
                                                              </picture>
                                                          </div>
                                                          <div class="bili-video-card__mask">
                                                              <div class="bili-video-card__stats">
                                                                  <div class="bili-video-card__stats--left">
                                                                      <!--[-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">107.2万</span>
                                                                      </span>
                                                                      <!--]-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">2611</span>
                                                                      </span>
                                                                  </div>
                                                                  <span class="bili-video-card__stats__duration">47:16</span>
                                                              </div>
                                                          </div>
                                                      </div>
                                                  </a>
                                                  <div style="" class="bili-video-card__info __scale-disable">
                                                      <!--[-->
                                                      <!---->
                                                      <!--]-->
                                                      <div class="bili-video-card__info--right">
                                                          <!---->
                                                          <h3 class="bili-video-card__info--tit" title="谨以此片献给每一位热爱原神的玩家！【耗时𝟏年高质量努力制作】">
                                                              <a href="https://www.bilibili.com/video/BV1f94y1u7ti" target="_blank">谨以此片献给每一位热爱原神的玩家！【耗时𝟏年高质量努力制作】</a>
                                                          </h3>
                                                          <div class="bili-video-card__info--bottom">
                                                              <!---->
                                                              <!--[-->
                                                              <a class="bili-video-card__info--owner" href="//space.bilibili.com/293753863" target="_blank">
                                                                  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="currentColor" class="bili-video-card__info--owner__up">
                                                                  <!--[-->
                                                                  <!--]-->
                                                                  </svg>
                                                                  <span class="bili-video-card__info--author" title="伊零Onezero">伊零Onezero</span>
                                                                  <span class="bili-video-card__info--date">· 2023-12-31</span>
                                                              </a>
                                                              <!--]-->
                                                          </div>
                                                      </div>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                      <div class="feed-card" data-v-3badd762>
                                          <div class="bili-video-card is-rcmd" style="--cover-radio:56.25%;" data-report="tianma.3-1-7.click" data-v-3badd762>
                                              <div class="bili-video-card__skeleton hide">
                                                  <div class="bili-video-card__skeleton--cover"></div>
                                                  <div class="bili-video-card__skeleton--info">
                                                      <div class="bili-video-card__skeleton--right">
                                                          <p class="bili-video-card__skeleton--text"></p>
                                                          <p class="bili-video-card__skeleton--text short"></p>
                                                          <p class="bili-video-card__skeleton--light"></p>
                                                      </div>
                                                  </div>
                                              </div>
                                              <div class="bili-video-card__wrap __scale-wrap">
                                                  <!---->
                                                  <a class="bili-video-card__image--link" href="https://www.bilibili.com/video/BV16w411E74S" target="_blank">
                                                      <div class="bili-video-card__image __scale-player-wrap bili-video-card__image--hover">
                                                          <div class="bili-video-card__image--wrap">
                                                              <!---->
                                                              <picture class="v-img bili-video-card__cover">
                                                                  <!--[-->
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/4c01bd69933cd4cc378e18a7edaba9813044ea07.jpg@672w_378h_1c_!web-home-common-cover.avif" type="image/avif">
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/4c01bd69933cd4cc378e18a7edaba9813044ea07.jpg@672w_378h_1c_!web-home-common-cover.webp" type="image/webp">
                                                                  <img src="//i1.hdslb.com/bfs/archive/4c01bd69933cd4cc378e18a7edaba9813044ea07.jpg@672w_378h_1c_!web-home-common-cover" alt="火遍全网的“工业大摸底”，堪称新时代的手撕鬼子【差评君】" loading="eager" onload onerror="typeof window.imgOnError === &#39;function&#39; &amp;&amp; window.imgOnError(this)">
                                                                  <!--]-->
                                                              </picture>
                                                          </div>
                                                          <div class="bili-video-card__mask">
                                                              <div class="bili-video-card__stats">
                                                                  <div class="bili-video-card__stats--left">
                                                                      <!--[-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">173.3万</span>
                                                                      </span>
                                                                      <!--]-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">6377</span>
                                                                      </span>
                                                                  </div>
                                                                  <span class="bili-video-card__stats__duration">10:40</span>
                                                              </div>
                                                          </div>
                                                      </div>
                                                  </a>
                                                  <div style="" class="bili-video-card__info __scale-disable">
                                                      <!--[-->
                                                      <!---->
                                                      <!--]-->
                                                      <div class="bili-video-card__info--right">
                                                          <!---->
                                                          <h3 class="bili-video-card__info--tit" title="火遍全网的“工业大摸底”，堪称新时代的手撕鬼子【差评君】">
                                                              <a href="https://www.bilibili.com/video/BV16w411E74S" target="_blank">火遍全网的“工业大摸底”，堪称新时代的手撕鬼子【差评君】</a>
                                                          </h3>
                                                          <div class="bili-video-card__info--bottom">
                                                              <!---->
                                                              <!--[-->
                                                              <a class="bili-video-card__info--owner" href="//space.bilibili.com/19319172" target="_blank">
                                                                  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="currentColor" class="bili-video-card__info--owner__up">
                                                                  <!--[-->
                                                                  <!--]-->
                                                                  </svg>
                                                                  <span class="bili-video-card__info--author" title="差评君">差评君</span>
                                                                  <span class="bili-video-card__info--date">· 1-12</span>
                                                              </a>
                                                              <!--]-->
                                                          </div>
                                                      </div>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                      <div class="feed-card" data-v-3badd762>
                                          <div class="bili-video-card is-rcmd" style="--cover-radio:56.25%;" data-report="tianma.3-2-8.click" data-v-3badd762>
                                              <div class="bili-video-card__skeleton hide">
                                                  <div class="bili-video-card__skeleton--cover"></div>
                                                  <div class="bili-video-card__skeleton--info">
                                                      <div class="bili-video-card__skeleton--right">
                                                          <p class="bili-video-card__skeleton--text"></p>
                                                          <p class="bili-video-card__skeleton--text short"></p>
                                                          <p class="bili-video-card__skeleton--light"></p>
                                                      </div>
                                                  </div>
                                              </div>
                                              <div class="bili-video-card__wrap __scale-wrap">
                                                  <!---->
                                                  <a class="bili-video-card__image--link" href="https://www.bilibili.com/video/BV1QC4y1q7FS" target="_blank">
                                                      <div class="bili-video-card__image __scale-player-wrap bili-video-card__image--hover">
                                                          <div class="bili-video-card__image--wrap">
                                                              <!---->
                                                              <picture class="v-img bili-video-card__cover">
                                                                  <!--[-->
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/9f2c169cbb17190f551e6573bbd20d3e05f7a891.jpg@672w_378h_1c_!web-home-common-cover.avif" type="image/avif">
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/9f2c169cbb17190f551e6573bbd20d3e05f7a891.jpg@672w_378h_1c_!web-home-common-cover.webp" type="image/webp">
                                                                  <img src="//i1.hdslb.com/bfs/archive/9f2c169cbb17190f551e6573bbd20d3e05f7a891.jpg@672w_378h_1c_!web-home-common-cover" alt="核心训练详解" loading="eager" onload="fsrCb()" onerror="typeof window.imgOnError === &#39;function&#39; &amp;&amp; window.imgOnError(this)">
                                                                  <!--]-->
                                                              </picture>
                                                          </div>
                                                          <div class="bili-video-card__mask">
                                                              <div class="bili-video-card__stats">
                                                                  <div class="bili-video-card__stats--left">
                                                                      <!--[-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">4.4万</span>
                                                                      </span>
                                                                      <!--]-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">59</span>
                                                                      </span>
                                                                  </div>
                                                                  <span class="bili-video-card__stats__duration">07:27</span>
                                                              </div>
                                                          </div>
                                                      </div>
                                                  </a>
                                                  <div style="" class="bili-video-card__info __scale-disable">
                                                      <!--[-->
                                                      <!---->
                                                      <!--]-->
                                                      <div class="bili-video-card__info--right">
                                                          <!---->
                                                          <h3 class="bili-video-card__info--tit" title="核心训练详解">
                                                              <a href="https://www.bilibili.com/video/BV1QC4y1q7FS" target="_blank">核心训练详解</a>
                                                          </h3>
                                                          <div class="bili-video-card__info--bottom">
                                                              <div class="bili-video-card__info--icon-text">已关注</div>
                                                              <!--[-->
                                                              <a class="bili-video-card__info--owner" href="//space.bilibili.com/2100737396" target="_blank">
                                                                  <!---->
                                                                  <span class="bili-video-card__info--author" title="凯圣王">凯圣王</span>
                                                                  <span class="bili-video-card__info--date">· 2023-12-26</span>
                                                              </a>
                                                              <!--]-->
                                                          </div>
                                                      </div>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                      <div class="feed-card" data-v-3badd762>
                                          <div class="bili-video-card is-rcmd" style="--cover-radio:56.25%;" data-report="tianma.3-3-9.click" data-v-3badd762>
                                              <div class="bili-video-card__skeleton hide">
                                                  <div class="bili-video-card__skeleton--cover"></div>
                                                  <div class="bili-video-card__skeleton--info">
                                                      <div class="bili-video-card__skeleton--right">
                                                          <p class="bili-video-card__skeleton--text"></p>
                                                          <p class="bili-video-card__skeleton--text short"></p>
                                                          <p class="bili-video-card__skeleton--light"></p>
                                                      </div>
                                                  </div>
                                              </div>
                                              <div class="bili-video-card__wrap __scale-wrap">
                                                  <!---->
                                                  <a class="bili-video-card__image--link" href="https://www.bilibili.com/video/BV1KC4y1e7rF" target="_blank">
                                                      <div class="bili-video-card__image __scale-player-wrap bili-video-card__image--hover">
                                                          <div class="bili-video-card__image--wrap">
                                                              <!---->
                                                              <picture class="v-img bili-video-card__cover">
                                                                  <!--[-->
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/1df78e1aba85dd51095b53157e050853ca6e558a.jpg@672w_378h_1c_!web-home-common-cover.avif" type="image/avif">
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/1df78e1aba85dd51095b53157e050853ca6e558a.jpg@672w_378h_1c_!web-home-common-cover.webp" type="image/webp">
                                                                  <img src="//i1.hdslb.com/bfs/archive/1df78e1aba85dd51095b53157e050853ca6e558a.jpg@672w_378h_1c_!web-home-common-cover" alt="雪衣全程单通黄金与机械难题12，主播打完直接昏厥！三十年来最爽的一把！" loading="eager" onload="fsrCb()" onerror="typeof window.imgOnError === &#39;function&#39; &amp;&amp; window.imgOnError(this)">
                                                                  <!--]-->
                                                              </picture>
                                                          </div>
                                                          <div class="bili-video-card__mask">
                                                              <div class="bili-video-card__stats">
                                                                  <div class="bili-video-card__stats--left">
                                                                      <!--[-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">60.4万</span>
                                                                      </span>
                                                                      <!--]-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">2205</span>
                                                                      </span>
                                                                  </div>
                                                                  <span class="bili-video-card__stats__duration">23:34</span>
                                                              </div>
                                                          </div>
                                                      </div>
                                                  </a>
                                                  <div style="" class="bili-video-card__info __scale-disable">
                                                      <!--[-->
                                                      <!---->
                                                      <!--]-->
                                                      <div class="bili-video-card__info--right">
                                                          <!---->
                                                          <h3 class="bili-video-card__info--tit" title="雪衣全程单通黄金与机械难题12，主播打完直接昏厥！三十年来最爽的一把！">
                                                              <a href="https://www.bilibili.com/video/BV1KC4y1e7rF" target="_blank">雪衣全程单通黄金与机械难题12，主播打完直接昏厥！三十年来最爽的一把！</a>
                                                          </h3>
                                                          <div class="bili-video-card__info--bottom">
                                                              <div class="bili-video-card__info--icon-text">4万点赞</div>
                                                              <!--[-->
                                                              <a class="bili-video-card__info--owner" href="//space.bilibili.com/75480955" target="_blank">
                                                                  <!---->
                                                                  <span class="bili-video-card__info--author" title="念熙阿">念熙阿</span>
                                                                  <span class="bili-video-card__info--date">· 1-13</span>
                                                              </a>
                                                              <!--]-->
                                                          </div>
                                                      </div>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                      <div class="feed-card" data-v-3badd762>
                                          <div class="bili-video-card is-rcmd" style="--cover-radio:56.25%;" data-report="tianma.3-4-10.click" data-v-3badd762>
                                              <div class="bili-video-card__skeleton hide">
                                                  <div class="bili-video-card__skeleton--cover"></div>
                                                  <div class="bili-video-card__skeleton--info">
                                                      <div class="bili-video-card__skeleton--right">
                                                          <p class="bili-video-card__skeleton--text"></p>
                                                          <p class="bili-video-card__skeleton--text short"></p>
                                                          <p class="bili-video-card__skeleton--light"></p>
                                                      </div>
                                                  </div>
                                              </div>
                                              <div class="bili-video-card__wrap __scale-wrap">
                                                  <!---->
                                                  <a class="bili-video-card__image--link" href="https://www.bilibili.com/video/BV1cN4y1i7h3" target="_blank">
                                                      <div class="bili-video-card__image __scale-player-wrap bili-video-card__image--hover">
                                                          <div class="bili-video-card__image--wrap">
                                                              <!---->
                                                              <picture class="v-img bili-video-card__cover">
                                                                  <!--[-->
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/1d2c849a53ef5004c707d830c4da0b57502569ce.jpg@672w_378h_1c_!web-home-common-cover.avif" type="image/avif">
                                                                  <source srcset="//i1.hdslb.com/bfs/archive/1d2c849a53ef5004c707d830c4da0b57502569ce.jpg@672w_378h_1c_!web-home-common-cover.webp" type="image/webp">
                                                                  <img src="//i1.hdslb.com/bfs/archive/1d2c849a53ef5004c707d830c4da0b57502569ce.jpg@672w_378h_1c_!web-home-common-cover" alt="《哆啦A梦》小夫家究竟有多富？直接造一个实体版来研究" loading="eager" onload="fsrCb()" onerror="typeof window.imgOnError === &#39;function&#39; &amp;&amp; window.imgOnError(this)">
                                                                  <!--]-->
                                                              </picture>
                                                          </div>
                                                          <div class="bili-video-card__mask">
                                                              <div class="bili-video-card__stats">
                                                                  <div class="bili-video-card__stats--left">
                                                                      <!--[-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">41.4万</span>
                                                                      </span>
                                                                      <!--]-->
                                                                      <span class="bili-video-card__stats--item">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="#ffffff" class="bili-video-card__stats--icon">
                                                                          <!--[-->
                                                                          <!--]-->
                                                                          </svg>
                                                                          <span class="bili-video-card__stats--text">1171</span>
                                                                      </span>
                                                                  </div>
                                                                  <span class="bili-video-card__stats__duration">10:14</span>
                                                              </div>
                                                          </div>
                                                      </div>
                                                  </a>
                                                  <div style="" class="bili-video-card__info __scale-disable">
                                                      <!--[-->
                                                      <!---->
                                                      <!--]-->
                                                      <div class="bili-video-card__info--right">
                                                          <!---->
                                                          <h3 class="bili-video-card__info--tit" title="《哆啦A梦》小夫家究竟有多富？直接造一个实体版来研究">
                                                              <a href="https://www.bilibili.com/video/BV1cN4y1i7h3" target="_blank">《哆啦A梦》小夫家究竟有多富？直接造一个实体版来研究</a>
                                                          </h3>
                                                          <div class="bili-video-card__info--bottom">
                                                              <!---->
                                                              <!--[-->
                                                              <a class="bili-video-card__info--owner" href="//space.bilibili.com/37607457" target="_blank">
                                                                  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" width="24" height="24" fill="currentColor" class="bili-video-card__info--owner__up">
                                                                  <!--[-->
                                                                  <!--]-->
                                                                  </svg>
                                                                  <span class="bili-video-card__info--author" title="凹凸赛克">凹凸赛克</span>
                                                                  <span class="bili-video-card__info--date">· 1-13</span>
                                                              </a>
                                                              <!--]-->
                                                          </div>
                                                      </div>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                      <!--]-->
                                      <!---->
                                      <!--]-->
                                      <!---->
                                      <!---->
                                      <!--]-->
                                  </div>
                                  <!---->
                                  <!---->
                                  <!---->
                              </div>
                              <!--]-->
                              <!---->
                          </div>
                      </main>
                      <!---->
                  </div>
                  <!--]-->
              </div>
              <script>
                  window.__INITIAL_DATA__ = [{
                      "request": {
                          "url": "http:\u002F\u002Fapi.bilibili.com\u002Fx\u002Fweb-show\u002Fpage\u002Fheader?resource_id=142",
                          "config": {
                              "preload": true,
                              "com2co": true,
                              "discovery": "main.web-svr.web-show",
                              "method": "GET",
                              "credentials": "include"
                          }
                      },
                      "response": {
                          "name": "",
                          "pic": "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Farchive\u002F721ecf6ed5ef7cf406e801216513f7f318353704.png",
                          "litpic": "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Farchive\u002Fc8fd97a40bf79f03e7b76cbc87236f612caef7b2.png",
                          "url": "",
                          "is_split_layer": 1,
                          "split_layer": "{\"version\":\"1\",\"layers\":[{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002Fcb5b4ca963e3a1a6d3917182561844b24a05fc20.png\",\"id\":0}],\"scale\":{\"initial\":1.2},\"rotate\":{},\"translate\":{},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":0,\"name\":\"19天空\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002Fbad95b1085650b58108b3491c9c13e1ef4e6b41f.png\",\"id\":0}],\"scale\":{\"initial\":1.2},\"rotate\":{},\"translate\":{\"offset\":[2,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":1,\"name\":\"19天空\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002Fb28b35a71a658e8bc449cd570337d7d9662d07d7.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"offset\":[12,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":2,\"name\":\"17极光\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002F596c782fe6636269c65a50a9188fd4d16d12a83e.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"initial\":[0,10]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":3,\"name\":\"16背景山\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002F4cbfd5b2c00e1abb157e9ca3e79380bfa40d2b26.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"initial\":[0,55],\"offset\":[100,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":4,\"name\":\"15冰面\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002F6b8bf544dec0088423136771f01696c68112a145.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"initial\":[0,40],\"offset\":[20,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":5,\"name\":\"14中景\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002Fcd6dadba219330bf44d3f8bcb584aede77d37f79.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"initial\":[-250,-10],\"offset\":[60,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":6,\"name\":\"13树\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002F31ff321fe1c2b003ab5c42beebb07f6c1652f66e.png\",\"id\":0}],\"scale\":{\"initial\":0.5},\"rotate\":{},\"translate\":{\"initial\":[600,50],\"offset\":[-150,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":11,\"name\":\"08狐狸\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002Fcfb54458ad3e2101d245f3434222e33453825f4e.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"initial\":[130,20],\"offset\":[70,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":7,\"name\":\"12中间房子+雪人\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002F5103762686dc9627619b028354c15ba2a72b0886.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"initial\":[-320,20],\"offset\":[100,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":10,\"name\":\"10大鹅\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002F09fa68c0c716596cebf6b1f81ed69a2a7a0a8c89.png\",\"id\":0}],\"scale\":{\"initial\":0.9},\"rotate\":{},\"translate\":{\"initial\":[-200,20],\"offset\":[120,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":9,\"name\":\"0933\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002Fc2914ea86a54203e59b9b9fb1b8ab3461a5976ed.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"initial\":[75,19],\"offset\":[150,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":8,\"name\":\"1122\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002F0cea6143cb8fce3ac55c0e1888a889c906a976aa.png\",\"id\":0}],\"scale\":{\"initial\":1.2},\"rotate\":{},\"translate\":{\"initial\":[-600,40],\"offset\":[200,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":12,\"name\":\"07左地面\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002Fc7cb3d67462676f79b3e702db60f4d4b038f3f28.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"initial\":[-600,-5],\"offset\":[400,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":13,\"name\":\"04冰屋\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002F459fbeaaff1fbeced05ac36f1cb0c0c70df3ff01.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"initial\":[-850,0],\"offset\":[500,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":14,\"name\":\"02左树\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002Fbba2f3520bedef31ef33a816f11a9d22487b80aa.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"initial\":[-1200,55],\"offset\":[700,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":15,\"name\":\"01左前植物\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002F7c2d36bba37320de03c417ed7d86111f7b05347e.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"initial\":[450,20],\"offset\":[500,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":17,\"name\":\"06右边雪人\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002Faa01bb2357ea84d7cc6cf3030769f2581a3ac98f.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"initial\":[350,50],\"offset\":[600,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":18,\"name\":\"05萝卜兔子\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002F89d1c8fb55797a064a4d4aca51be2ebb8d86643a.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"initial\":[700,0],\"offset\":[800,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":16,\"name\":\"03右树\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002Fbba2f3520bedef31ef33a816f11a9d22487b80aa.png\",\"id\":0}],\"scale\":{},\"rotate\":{},\"translate\":{\"initial\":[1200,55],\"offset\":[850,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":20,\"name\":\"前树\"},{\"resources\":[{\"src\":\"https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fvc\u002F3b226df45a1d6af2cdfeb20b9963849e13356f3d.webm\",\"id\":0}],\"scale\":{\"initial\":1.1},\"rotate\":{},\"translate\":{\"offset\":[50,0]},\"blur\":{},\"opacity\":{\"wrap\":\"clamp\"},\"id\":19,\"name\":\"下雪\"}]}",
                          "request_id": "1705300832"
                      }
                  }, {
                      "request": {
                          "url": "http:\u002F\u002Fapi.bilibili.com\u002Fx\u002Fweb-show\u002Fres\u002Flocs?pf=0&ids=4694",
                          "config": {
                              "preload": true,
                              "com2co": true,
                              "encWbi": true,
                              "discovery": "main.web-svr.web-show",
                              "method": "GET",
                              "credentials": "include"
                          }
                      },
                      "response": {
                          "4694": [{
                              "id": 1436628,
                              "contract_id": "",
                              "res_id": 4695,
                              "asg_id": 1415364,
                              "pos_num": 1,
                              "name": "2024哔哩哔哩拜年纪火热预约中！",
                              "pic": "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fbanner\u002F4e9564fe2022ac35bc5337e0f73f47713cab6f47.jpg",
                              "litpic": "",
                              "url": "https:\u002F\u002Fwww.bilibili.com\u002Fblackboard\u002Fbnj2024.html?auto_media_playback=1&msource=sz",
                              "style": 0,
                              "agency": "",
                              "label": "",
                              "intro": "",
                              "creative_type": 0,
                              "request_id": "1705300832",
                              "src_id": 4695,
                              "area": 4,
                              "is_ad_loc": false,
                              "ad_cb": "",
                              "title": "",
                              "server_type": 0,
                              "cm_mark": 0,
                              "stime": 1705287600,
                              "mid": "51218333",
                              "activity_type": 0,
                              "epid": 0,
                              "season": null,
                              "room": null,
                              "sub_title": "",
                              "ad_desc": "",
                              "adver_name": "",
                              "null_frame": false,
                              "pic_main_color": "#3d2111",
                              "card_type": 0,
                              "business_mark": null,
                              "inline": {
                                  "inline_use_same": 1,
                                  "inline_type": 0,
                                  "inline_url": "",
                                  "inline_barrage_switch": 1
                              },
                              "operater": "manager_banner_10948"
                          }, {
                              "id": 1437977,
                              "contract_id": "",
                              "res_id": 4694,
                              "asg_id": 1416617,
                              "pos_num": 2,
                              "name": "闪电麦昆热血冲刺，风风火火闯世界！",
                              "pic": "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fbanner\u002F70fc2886e274f394e49d5d859104f4ee92ab3d7d.png",
                              "litpic": "#2c232a",
                              "url": "https:\u002F\u002Fwww.bilibili.com\u002Fbangumi\u002Fplay\u002Fep810659",
                              "style": 0,
                              "agency": "",
                              "label": "",
                              "intro": "",
                              "creative_type": 0,
                              "request_id": "1705300832266q172a27a109a212q436",
                              "src_id": 4696,
                              "area": 4,
                              "is_ad_loc": true,
                              "ad_cb": "",
                              "title": "",
                              "server_type": 0,
                              "cm_mark": 0,
                              "stime": 1705233600,
                              "mid": "51218333",
                              "activity_type": 0,
                              "epid": 0,
                              "season": null,
                              "room": null,
                              "sub_title": "",
                              "ad_desc": "",
                              "adver_name": "",
                              "null_frame": false,
                              "pic_main_color": "",
                              "card_type": 0,
                              "business_mark": null,
                              "inline": {
                                  "inline_use_same": 1,
                                  "inline_type": 0,
                                  "inline_url": "",
                                  "inline_barrage_switch": 1
                              },
                              "operater": "manager_banner_10948"
                          }, {
                              "id": 0,
                              "contract_id": "",
                              "res_id": 0,
                              "asg_id": 0,
                              "pos_num": 3,
                              "name": "百万现金以及游戏道具助力创作&开播",
                              "pic": "https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fsycp\u002Fcreative_img\u002F202401\u002F6c59018228a606da504f7f043cad19ae.jpg",
                              "litpic": "",
                              "url": "https:\u002F\u002Fwww.bilibili.com\u002Fblackboard\u002Factivity-lQDoCocxQt.html",
                              "style": 0,
                              "is_ad": true,
                              "agency": "",
                              "label": "",
                              "intro": "",
                              "creative_type": 0,
                              "request_id": "1705300832266q172a27a109a212q436",
                              "creative_id": 847866393459695600,
                              "src_id": 4697,
                              "area": 4,
                              "is_ad_loc": true,
                              "ad_cb": "CAAQABiAwKD54b+O4gsgACgAMB042SRCIDE3MDUzMDA4MzIyNjZxMTcyYTI3YTEwOWEyMTJxNDM2SIrg5t7QMVIJ5bCa5L2p5oGpWg\u002FkvIrliKnor7rkvIrlt55iBue+juWbvWgBcAF4gICAgMAhgAEAiAHp\u002FgKSAQ42Ni4yNTMuMTgzLjIzNpoBAKABALIBIOXijbK4r8GtU\u002FbYdpWJFJZg0NjA+AwuWeAictMU3zIougE8aHR0cHM6Ly93d3cuYmlsaWJpbGkuY29tL2JsYWNrYm9hcmQvYWN0aXZpdHktbFFEb0NvY3hRdC5odG1swgEA0gEA2AGMAuABAOgBAPABAIACAogCALgCAMACANACANgCAOoCAPAC74se+AIAiAMEkgMAqAMAsAMAuAMAwgMAyAMr0gN3eyIxNiI6IjI5XzAiLCIxNyI6IjQ2OTQiLCIxIjoiODQ3ODY2MzkzNDU5Njk1NjE2IiwiMiI6IjI5IiwiMyI6IjI5IiwiNiI6IjI5XzAiLCIxMiI6IjQ2OTciLCIxMyI6IjI5IiwiMTQiOiIwIiwiMTUiOiIwIn3gAwDoAwXwAwD6AwVvdGhlcoIECW51bGw6bnVsbJgEAKAEAKoEBAgAEASwBADiBJgBNTYueyJwc0lkIjoxNzIxNSwidjIiOiJIT3o4LWtSaDJvYmt4dWEwYmJwekpiZDdBaWxqdHBNR2NtazgtcUdmb2pZalhheDEtMHJKTy14U2tpcm5lV3FibUZIOG04Q0FlVjI0QzlsY2JLa3M1STlpTHhOS1ZPRnRPVkkifTs2My57InBzSWQiOjE2NzU4LCJ2MiI6ImZBIn2gBQDIBQLSBQA=",
                              "title": "百万现金以及游戏道具助力创作&开播",
                              "server_type": 1,
                              "cm_mark": 1,
                              "stime": 0,
                              "mid": "51218333",
                              "activity_type": 0,
                              "epid": 0,
                              "season": null,
                              "room": null,
                              "sub_title": "",
                              "ad_desc": "",
                              "adver_name": "",
                              "null_frame": false,
                              "pic_main_color": "",
                              "card_type": 0,
                              "business_mark": {
                                  "type": 2,
                                  "text": "广告",
                                  "text_color": "#999999FF",
                                  "bg_border_color": "#999999FF",
                                  "bg_color": "#999999FF",
                                  "border_color": "#999999FF"
                              },
                              "inline": {
                                  "inline_use_same": 0,
                                  "inline_type": 0,
                                  "inline_url": "",
                                  "inline_barrage_switch": 0
                              },
                              "operater": ""
                          }, {
                              "id": 1438310,
                              "contract_id": "",
                              "res_id": 4694,
                              "asg_id": 1416911,
                              "pos_num": 4,
                              "name": "太狡猾了！外观设定过分可爱！",
                              "pic": "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fbanner\u002F4e7b2b1eea5c0e0c289f64ae20decd0d68a30cae.png",
                              "litpic": "#5f3c1c",
                              "url": "https:\u002F\u002Fwww.bilibili.com\u002Fbangumi\u002Fplay\u002Fep810837",
                              "style": 0,
                              "agency": "",
                              "label": "",
                              "intro": "",
                              "creative_type": 0,
                              "request_id": "1705300832",
                              "src_id": 4698,
                              "area": 4,
                              "is_ad_loc": false,
                              "ad_cb": "",
                              "title": "",
                              "server_type": 0,
                              "cm_mark": 0,
                              "stime": 1705287600,
                              "mid": "51218333",
                              "activity_type": 0,
                              "epid": 0,
                              "season": null,
                              "room": null,
                              "sub_title": "",
                              "ad_desc": "",
                              "adver_name": "",
                              "null_frame": false,
                              "pic_main_color": "",
                              "card_type": 0,
                              "business_mark": null,
                              "inline": {
                                  "inline_use_same": 1,
                                  "inline_type": 0,
                                  "inline_url": "",
                                  "inline_barrage_switch": 1
                              },
                              "operater": "manager_banner_10948"
                          }, {
                              "id": 1438239,
                              "contract_id": "",
                              "res_id": 4694,
                              "asg_id": 1416840,
                              "pos_num": 5,
                              "name": "豆瓣9.2！一百年前的外科手术是怎么做的",
                              "pic": "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fbanner\u002F6b623e10c9faad9add149f0aef830ecd6421af65.jpg",
                              "litpic": "#4a494a",
                              "url": "https:\u002F\u002Fwww.bilibili.com\u002Fbangumi\u002Fplay\u002Fss47113",
                              "style": 0,
                              "agency": "",
                              "label": "",
                              "intro": "",
                              "creative_type": 0,
                              "request_id": "1705300832",
                              "src_id": 4699,
                              "area": 4,
                              "is_ad_loc": false,
                              "ad_cb": "",
                              "title": "",
                              "server_type": 0,
                              "cm_mark": 0,
                              "stime": 1705291260,
                              "mid": "51218333",
                              "activity_type": 0,
                              "epid": 0,
                              "season": null,
                              "room": null,
                              "sub_title": "",
                              "ad_desc": "",
                              "adver_name": "",
                              "null_frame": false,
                              "pic_main_color": "",
                              "card_type": 0,
                              "business_mark": null,
                              "inline": {
                                  "inline_use_same": 1,
                                  "inline_type": 0,
                                  "inline_url": "",
                                  "inline_barrage_switch": 1
                              },
                              "operater": "manager_banner_10948"
                          }, {
                              "id": 1439142,
                              "contract_id": "",
                              "res_id": 4694,
                              "asg_id": 1417724,
                              "pos_num": 6,
                              "name": "年度奖项荣耀加冕！精彩内容全程回顾\u003E\u003E\u003E",
                              "pic": "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fbanner\u002Fc7e9f2ba5958678be447d2b87f237a8a3fc1e72f.png",
                              "litpic": "#392d25",
                              "url": "http:\u002F\u002Fwww.bilibili.com\u002Fvideo\u002FBV1fC4y1Y7q6",
                              "style": 0,
                              "archive": {
                                  "aid": 793693832,
                                  "videos": 1,
                                  "tid": 71,
                                  "tname": "综艺",
                                  "copyright": 1,
                                  "pic": "http:\u002F\u002Fi1.hdslb.com\u002Fbfs\u002Farchive\u002F05fc501fbd4738fea77aa6e0a137b2dc7bd77f56.jpg",
                                  "title": "BLS2023 年度直播之夜｜盛典全程回顾",
                                  "pubdate": 1705150800,
                                  "ctime": 1705069383,
                                  "desc": "BLS2023直播年度之夜 获奖主播完整名单\u003E\u003E\u003Ehttps:\u002F\u002Flive.bilibili.com\u002Fblackboard\u002Factivity-xhVS2dCtVJ.html\n恭喜各位获奖主播，感谢你们过去一年为大家带来的陪伴与欢乐，期待未来看到你们更精彩的直播内容~",
                                  "state": 0,
                                  "duration": 5221,
                                  "rights": {
                                      "bp": 0,
                                      "elec": 0,
                                      "download": 0,
                                      "movie": 0,
                                      "pay": 0,
                                      "hd5": 0,
                                      "no_reprint": 0,
                                      "autoplay": 1,
                                      "ugc_pay": 0,
                                      "is_cooperation": 0,
                                      "ugc_pay_preview": 0,
                                      "no_background": 0,
                                      "arc_pay": 0,
                                      "pay_free_watch": 0
                                  },
                                  "owner": {
                                      "mid": 9617619,
                                      "name": "哔哩哔哩直播",
                                      "face": "https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fface\u002F8f6a614a48a3813d90da7a11894ae56a59396fcd.jpg"
                                  },
                                  "stat": {
                                      "aid": 793693832,
                                      "view": 398164,
                                      "danmaku": 927,
                                      "reply": 357,
                                      "favorite": 1178,
                                      "coin": 184,
                                      "share": 186,
                                      "now_rank": 0,
                                      "his_rank": 0,
                                      "like": 5488,
                                      "dislike": 0,
                                      "vt": 0,
                                      "vv": 398164
                                  },
                                  "dynamic": "BLS2023直播年度之夜 获奖主播完整名单\u003E\u003E\u003Ehttps:\u002F\u002Flive.bilibili.com\u002Fblackboard\u002Factivity-xhVS2dCtVJ.html\n恭喜各位获奖主播，感谢你们过去一年为大家带来的陪伴与欢乐，期待未来看到你们更精彩的直播内容~",
                                  "cid": 1405329177,
                                  "dimension": {
                                      "width": 1920,
                                      "height": 1080,
                                      "rotate": 0
                                  },
                                  "season_id": 2053891,
                                  "short_link_v2": "https:\u002F\u002Fb23.tv\u002FBV1fC4y1Y7q6",
                                  "pub_location": "上海",
                                  "bvid": "BV1fC4y1Y7q6",
                                  "enable_vt": 0
                              },
                              "agency": "",
                              "label": "",
                              "intro": "",
                              "creative_type": 0,
                              "request_id": "1705300832",
                              "src_id": 4700,
                              "area": 4,
                              "is_ad_loc": false,
                              "ad_cb": "",
                              "title": "",
                              "server_type": 0,
                              "cm_mark": 0,
                              "stime": 1705291200,
                              "mid": "51218333",
                              "activity_type": 0,
                              "epid": 0,
                              "season": null,
                              "room": null,
                              "sub_title": "",
                              "ad_desc": "",
                              "adver_name": "",
                              "null_frame": false,
                              "pic_main_color": "",
                              "card_type": 0,
                              "business_mark": null,
                              "inline": {
                                  "inline_use_same": 1,
                                  "inline_type": 0,
                                  "inline_url": "",
                                  "inline_barrage_switch": 1
                              },
                              "operater": "manager_banner_10948"
                          }, {
                              "id": 1437890,
                              "contract_id": "",
                              "res_id": 4694,
                              "asg_id": 1416530,
                              "pos_num": 7,
                              "name": "豆瓣8.5！火星版“荒野求生”",
                              "pic": "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fbanner\u002Fb897fe5f96529bc1e06aa6f1f34d9c2683ed5f78.png",
                              "litpic": "#15161b",
                              "url": "https:\u002F\u002Fwww.bilibili.com\u002Fbangumi\u002Fplay\u002Fep810653",
                              "style": 0,
                              "agency": "",
                              "label": "",
                              "intro": "",
                              "creative_type": 0,
                              "request_id": "1705300832266q172a27a109a212q436",
                              "src_id": 4701,
                              "area": 4,
                              "is_ad_loc": true,
                              "ad_cb": "",
                              "title": "",
                              "server_type": 0,
                              "cm_mark": 0,
                              "stime": 1705233600,
                              "mid": "51218333",
                              "activity_type": 0,
                              "epid": 0,
                              "season": null,
                              "room": null,
                              "sub_title": "",
                              "ad_desc": "",
                              "adver_name": "",
                              "null_frame": false,
                              "pic_main_color": "",
                              "card_type": 0,
                              "business_mark": null,
                              "inline": {
                                  "inline_use_same": 1,
                                  "inline_type": 0,
                                  "inline_url": "",
                                  "inline_barrage_switch": 1
                              },
                              "operater": "manager_banner_10948"
                          }, {
                              "id": 1437472,
                              "contract_id": "",
                              "res_id": 4694,
                              "asg_id": 1416175,
                              "pos_num": 8,
                              "name": "细思极恐！一场撕扯人性的游戏",
                              "pic": "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fbanner\u002Faf3807b04f969e2fbfe4ad15f9a6c4b73c6b5c89.png",
                              "litpic": "#2d2630",
                              "url": "https:\u002F\u002Fwww.bilibili.com\u002Fbangumi\u002Fplay\u002Fep810519",
                              "style": 0,
                              "agency": "",
                              "label": "",
                              "intro": "",
                              "creative_type": 0,
                              "request_id": "1705300832266q172a27a109a212q436",
                              "src_id": 4702,
                              "area": 4,
                              "is_ad_loc": true,
                              "ad_cb": "",
                              "title": "",
                              "server_type": 0,
                              "cm_mark": 0,
                              "stime": 1705233600,
                              "mid": "51218333",
                              "activity_type": 0,
                              "epid": 0,
                              "season": null,
                              "room": null,
                              "sub_title": "",
                              "ad_desc": "",
                              "adver_name": "",
                              "null_frame": false,
                              "pic_main_color": "",
                              "card_type": 0,
                              "business_mark": null,
                              "inline": {
                                  "inline_use_same": 1,
                                  "inline_type": 0,
                                  "inline_url": "",
                                  "inline_barrage_switch": 1
                              },
                              "operater": "manager_banner_10948"
                          }, {
                              "id": 1437905,
                              "contract_id": "",
                              "res_id": 4694,
                              "asg_id": 1416545,
                              "pos_num": 9,
                              "name": "人猿决战！猩球崛起系列上线",
                              "pic": "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fbanner\u002Fce7edbce9a30a5ea1cb823c5f4031b174988c15e.png",
                              "litpic": "#2a292a",
                              "url": "https:\u002F\u002Fwww.bilibili.com\u002Fbangumi\u002Fplay\u002Fep810647",
                              "style": 0,
                              "agency": "",
                              "label": "",
                              "intro": "",
                              "creative_type": 0,
                              "request_id": "1705300832266q172a27a109a212q436",
                              "src_id": 4703,
                              "area": 4,
                              "is_ad_loc": true,
                              "ad_cb": "",
                              "title": "",
                              "server_type": 0,
                              "cm_mark": 0,
                              "stime": 1705287600,
                              "mid": "51218333",
                              "activity_type": 0,
                              "epid": 0,
                              "season": null,
                              "room": null,
                              "sub_title": "",
                              "ad_desc": "",
                              "adver_name": "",
                              "null_frame": false,
                              "pic_main_color": "",
                              "card_type": 0,
                              "business_mark": null,
                              "inline": {
                                  "inline_use_same": 1,
                                  "inline_type": 0,
                                  "inline_url": "",
                                  "inline_barrage_switch": 1
                              },
                              "operater": "manager_banner_10948"
                          }, {
                              "id": 1437050,
                              "contract_id": "",
                              "res_id": 4694,
                              "asg_id": 1415763,
                              "pos_num": 10,
                              "name": "跟练跳操动起来，强身健体防流感",
                              "pic": "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fbanner\u002F98875443a04511eebcf670e25d15fa91dd83878e.jpg",
                              "litpic": "#7d8985",
                              "url": "https:\u002F\u002Fwww.bilibili.com\u002Fblackboard\u002Factivity-2drivDpzZU.html",
                              "style": 0,
                              "agency": "",
                              "label": "",
                              "intro": "",
                              "creative_type": 0,
                              "request_id": "1705300832",
                              "src_id": 4704,
                              "area": 4,
                              "is_ad_loc": false,
                              "ad_cb": "",
                              "title": "",
                              "server_type": 0,
                              "cm_mark": 0,
                              "stime": 1705248000,
                              "mid": "51218333",
                              "activity_type": 0,
                              "epid": 0,
                              "season": null,
                              "room": null,
                              "sub_title": "",
                              "ad_desc": "",
                              "adver_name": "",
                              "null_frame": false,
                              "pic_main_color": "",
                              "card_type": 0,
                              "business_mark": null,
                              "inline": {
                                  "inline_use_same": 1,
                                  "inline_type": 0,
                                  "inline_url": "",
                                  "inline_barrage_switch": 1
                              },
                              "operater": "manager_banner_10948"
                          }]
                      }
                  }]
              </script>
              <script type="text/javascript">
                  window.__pinia = (function(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, _, $, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at, au, av, aw, ax, ay, az, aA, aB, aC, aD, aE, aF, aG, aH, aI, aJ, aK, aL, aM, aN, aO, aP, aQ, aR, aS, aT, aU, aV, aW, aX, aY, aZ, a_, a$, ba, bb, bc, bd, be, bf, bg, bh, bi, bj, bk, bl, bm, bn, bo, bp, bq, br, bs, bt, bu, bv, bw, bx, by, bz, bA, bB, bC, bD, bE, bF, bG, bH, bI, bJ, bK, bL, bM, bN, bO, bP, bQ, bR, bS, bT, bU, bV, bW, bX, bY, bZ, b_, b$, ca, cb, cc, cd, ce, cf, cg, ch, ci, cj, ck, cl, cm, cn, co, cp, cq, cr, cs, ct, cu, cv, cw, cx, cy, cz, cA, cB, cC, cD, cE, cF, cG, cH, cI, cJ, cK, cL, cM, cN, cO, cP, cQ, cR, cS, cT, cU, cV, cW, cX, cY, cZ, c_, c$, da, db, dc, dd, de, df, dg, dh, di) {
                      ae.freshIdx = a;
                      ae.id = y;
                      ae.reportId = "av_n_368054110";
                      af.freshIdx = a;
                      af.id = z;
                      af.reportId = "av_n_236892856";
                      ag.freshIdx = a;
                      ag.id = A;
                      ag.reportId = "av_n_278714067";
                      ah.freshIdx = a;
                      ah.id = B;
                      ah.reportId = "av_n_793230179";
                      ai.freshIdx = a;
                      ai.id = L;
                      ai.reportId = "ad_n_5614";
                      aj.freshIdx = a;
                      aj.id = C;
                      aj.reportId = "av_n_368084374";
                      ak.freshIdx = a;
                      ak.id = D;
                      ak.reportId = "av_n_326130779";
                      al.freshIdx = a;
                      al.id = E;
                      al.reportId = "av_n_792873475";
                      am.freshIdx = a;
                      am.id = F;
                      am.reportId = "av_n_793678795";
                      an.freshIdx = a;
                      an.id = G;
                      an.reportId = "av_n_878690552";
                      br.bg_border_color = T;
                      br.bg_color = d;
                      br.bg_color_night = d;
                      br.border_color = T;
                      br.border_color_night = bs;
                      br.img_height = a;
                      br.img_url = d;
                      br.img_width = a;
                      br.text = "广告";
                      br.text_color = T;
                      br.text_color_night = bs;
                      br.type = t;
                      return {
                          index: {
                              enableAvif: e,
                              bmgDefDomain: "i1.hdslb.com",
                              homeVersion: ad,
                              smallest: f,
                              xs_sm: f,
                              xs: f,
                              sm: f,
                              md: f,
                              lg: f,
                              xl: f,
                              xxl: f,
                              popWindowVersion: "V1",
                              experimentConstants: {
                                  loginBackBlockCountingSecond: 210,
                                  previewTipCountingSecond: b,
                                  previewCountingSecond: q,
                                  nanoVersionHash: "a8c001e3",
                                  nanoVersionPipHash: "29587de4",
                                  nanoVersionPcdnHash: "57abf745",
                                  tianma_banner_inline_V0: x,
                                  tianma_banner_inline_V1: J,
                                  continuousHistoryThreshold: 1200,
                                  continuousHistoryVisibleDuration: K
                              },
                              themeSwitchVersion: "CLOSE",
                              tianmaBannerInlineVersion: "CONTROL",
                              exitFeedBtnVersion: "HIDE",
                              forceToFeedVersion: "GO",
                              desktopDownloadTipVersion: "SHOW",
                              enableWebPushVersion: "DISABLE"
                          },
                          feed: {
                              feedReqCardList: [ae, af, ag, ah, ai, aj, ak, al, am, an],
                              currentReqList: [ae, af, ag, ah, ai, aj, ak, al, am, an],
                              homeVersion: ad,
                              refreshed: f,
                              hasMoreHeadRecommend: e,
                              banner_card_cur_idx: a,
                              brush: {
                                  dropDown: a,
                                  refresh: x
                              },
                              fresh_type: a,
                              timestamp: 1705300832098,
                              fresh_idx_1h: a,
                              fresh_idx: a,
                              fetch_row: b,
                              data: {
                                  loading: f,
                                  ad: [],
                                  banner_card: [],
                                  recommend: {
                                      item: [{
                                          id: y,
                                          bvid: ao,
                                          cid: ap,
                                          goto: l,
                                          uri: aq,
                                          pic: M,
                                          pic_4_3: ar,
                                          title: as,
                                          duration: at,
                                          pubdate: au,
                                          owner: {
                                              mid: av,
                                              name: aw,
                                              face: ax
                                          },
                                          stat: {
                                              view: ay,
                                              like: az,
                                              danmaku: H,
                                              vt: a
                                          },
                                          av_feature: c,
                                          is_followed: b,
                                          rcmd_reason: {
                                              reason_type: b
                                          },
                                          show_info: b,
                                          track_id: k,
                                          pos: a,
                                          room_info: c,
                                          ogv_info: c,
                                          business_info: c,
                                          is_stock: a,
                                          enable_vt: a,
                                          vt_display: d,
                                          fresh_idx: a
                                      }, {
                                          id: z,
                                          bvid: aA,
                                          cid: aB,
                                          goto: l,
                                          uri: aC,
                                          pic: N,
                                          pic_4_3: aD,
                                          title: aE,
                                          duration: aF,
                                          pubdate: aG,
                                          owner: {
                                              mid: aH,
                                              name: aI,
                                              face: aJ
                                          },
                                          stat: {
                                              view: aK,
                                              like: aL,
                                              danmaku: aM,
                                              vt: a
                                          },
                                          av_feature: c,
                                          is_followed: a,
                                          rcmd_reason: {
                                              content: aN,
                                              reason_type: o
                                          },
                                          show_info: b,
                                          track_id: k,
                                          pos: a,
                                          room_info: c,
                                          ogv_info: c,
                                          business_info: c,
                                          is_stock: a,
                                          enable_vt: a,
                                          vt_display: d,
                                          fresh_idx: a
                                      }, {
                                          id: A,
                                          bvid: aO,
                                          cid: aP,
                                          goto: l,
                                          uri: aQ,
                                          pic: O,
                                          pic_4_3: aR,
                                          title: aS,
                                          duration: aT,
                                          pubdate: aU,
                                          owner: {
                                              mid: aV,
                                              name: aW,
                                              face: aX
                                          },
                                          stat: {
                                              view: aY,
                                              like: aZ,
                                              danmaku: a_,
                                              vt: a
                                          },
                                          av_feature: c,
                                          is_followed: a,
                                          rcmd_reason: {
                                              reason_type: a
                                          },
                                          show_info: b,
                                          track_id: k,
                                          pos: a,
                                          room_info: c,
                                          ogv_info: c,
                                          business_info: c,
                                          is_stock: a,
                                          enable_vt: a,
                                          vt_display: d,
                                          fresh_idx: a
                                      }, {
                                          id: B,
                                          bvid: a$,
                                          cid: ba,
                                          goto: l,
                                          uri: bb,
                                          pic: P,
                                          pic_4_3: bc,
                                          title: bd,
                                          duration: be,
                                          pubdate: bf,
                                          owner: {
                                              mid: bg,
                                              name: bh,
                                              face: bi
                                          },
                                          stat: {
                                              view: bj,
                                              like: bk,
                                              danmaku: bl,
                                              vt: a
                                          },
                                          av_feature: c,
                                          is_followed: a,
                                          rcmd_reason: {
                                              reason_type: a
                                          },
                                          show_info: b,
                                          track_id: k,
                                          pos: a,
                                          room_info: c,
                                          ogv_info: c,
                                          business_info: c,
                                          is_stock: a,
                                          enable_vt: a,
                                          vt_display: d,
                                          fresh_idx: a
                                      }, {
                                          id: a,
                                          bvid: d,
                                          cid: a,
                                          goto: bm,
                                          uri: d,
                                          pic: d,
                                          pic_4_3: d,
                                          title: d,
                                          duration: a,
                                          pubdate: a,
                                          owner: c,
                                          stat: c,
                                          av_feature: c,
                                          is_followed: a,
                                          rcmd_reason: c,
                                          show_info: a,
                                          track_id: k,
                                          pos: a,
                                          room_info: c,
                                          ogv_info: c,
                                          business_info: {
                                              id: a,
                                              contract_id: d,
                                              res_id: a,
                                              asg_id: a,
                                              pos_num: b,
                                              name: Q,
                                              pic: bn,
                                              litpic: d,
                                              url: R,
                                              style: a,
                                              is_ad: e,
                                              agency: d,
                                              label: d,
                                              intro: d,
                                              creative_type: a,
                                              request_id: bo,
                                              creative_id: S,
                                              src_id: L,
                                              area: a,
                                              is_ad_loc: e,
                                              ad_cb: bp,
                                              title: Q,
                                              server_type: b,
                                              cm_mark: b,
                                              stime: a,
                                              mid: d,
                                              activity_type: a,
                                              epid: a,
                                              sub_title: d,
                                              ad_desc: "测测你的岗位薪资",
                                              adver_name: bq,
                                              null_frame: f,
                                              pic_main_color: d,
                                              card_type: a,
                                              business_mark: br,
                                              inline: {
                                                  inline_use_same: a,
                                                  inline_type: a,
                                                  inline_url: d,
                                                  inline_barrage_switch: a
                                              },
                                              operater: d
                                          },
                                          is_stock: a,
                                          enable_vt: a,
                                          vt_display: d,
                                          fresh_idx: a
                                      }, {
                                          id: C,
                                          bvid: bt,
                                          cid: bu,
                                          goto: l,
                                          uri: bv,
                                          pic: U,
                                          pic_4_3: bw,
                                          title: bx,
                                          duration: by,
                                          pubdate: bz,
                                          owner: {
                                              mid: bA,
                                              name: bB,
                                              face: bC
                                          },
                                          stat: {
                                              view: bD,
                                              like: bE,
                                              danmaku: bF,
                                              vt: a
                                          },
                                          av_feature: c,
                                          is_followed: a,
                                          rcmd_reason: {
                                              reason_type: a
                                          },
                                          show_info: b,
                                          track_id: k,
                                          pos: a,
                                          room_info: c,
                                          ogv_info: c,
                                          business_info: c,
                                          is_stock: a,
                                          enable_vt: a,
                                          vt_display: d,
                                          fresh_idx: a
                                      }, {
                                          id: D,
                                          bvid: bG,
                                          cid: bH,
                                          goto: l,
                                          uri: bI,
                                          pic: V,
                                          pic_4_3: bJ,
                                          title: bK,
                                          duration: bL,
                                          pubdate: bM,
                                          owner: {
                                              mid: bN,
                                              name: bO,
                                              face: bP
                                          },
                                          stat: {
                                              view: bQ,
                                              like: bR,
                                              danmaku: bS,
                                              vt: a
                                          },
                                          av_feature: c,
                                          is_followed: a,
                                          rcmd_reason: {
                                              reason_type: a
                                          },
                                          show_info: b,
                                          track_id: k,
                                          pos: a,
                                          room_info: c,
                                          ogv_info: c,
                                          business_info: c,
                                          is_stock: a,
                                          enable_vt: a,
                                          vt_display: d,
                                          fresh_idx: a
                                      }, {
                                          id: E,
                                          bvid: bT,
                                          cid: bU,
                                          goto: l,
                                          uri: bV,
                                          pic: W,
                                          pic_4_3: bW,
                                          title: bX,
                                          duration: bY,
                                          pubdate: bZ,
                                          owner: {
                                              mid: b_,
                                              name: b$,
                                              face: ca
                                          },
                                          stat: {
                                              view: cb,
                                              like: cc,
                                              danmaku: cd,
                                              vt: a
                                          },
                                          av_feature: c,
                                          is_followed: b,
                                          rcmd_reason: {
                                              reason_type: b
                                          },
                                          show_info: b,
                                          track_id: k,
                                          pos: a,
                                          room_info: c,
                                          ogv_info: c,
                                          business_info: c,
                                          is_stock: a,
                                          enable_vt: a,
                                          vt_display: d,
                                          fresh_idx: a
                                      }, {
                                          id: F,
                                          bvid: ce,
                                          cid: cf,
                                          goto: l,
                                          uri: cg,
                                          pic: X,
                                          pic_4_3: ch,
                                          title: ci,
                                          duration: cj,
                                          pubdate: ck,
                                          owner: {
                                              mid: cl,
                                              name: cm,
                                              face: cn
                                          },
                                          stat: {
                                              view: co,
                                              like: cp,
                                              danmaku: cq,
                                              vt: a
                                          },
                                          av_feature: c,
                                          is_followed: a,
                                          rcmd_reason: {
                                              content: cr,
                                              reason_type: o
                                          },
                                          show_info: b,
                                          track_id: k,
                                          pos: a,
                                          room_info: c,
                                          ogv_info: c,
                                          business_info: c,
                                          is_stock: a,
                                          enable_vt: a,
                                          vt_display: d,
                                          fresh_idx: a
                                      }, {
                                          id: G,
                                          bvid: cs,
                                          cid: ct,
                                          goto: l,
                                          uri: cu,
                                          pic: Y,
                                          pic_4_3: cv,
                                          title: cw,
                                          duration: cx,
                                          pubdate: cy,
                                          owner: {
                                              mid: cz,
                                              name: cA,
                                              face: cB
                                          },
                                          stat: {
                                              view: cC,
                                              like: cD,
                                              danmaku: cE,
                                              vt: a
                                          },
                                          av_feature: c,
                                          is_followed: a,
                                          rcmd_reason: {
                                              reason_type: a
                                          },
                                          show_info: b,
                                          track_id: k,
                                          pos: a,
                                          room_info: c,
                                          ogv_info: c,
                                          business_info: c,
                                          is_stock: a,
                                          enable_vt: a,
                                          vt_display: d,
                                          fresh_idx: a
                                      }],
                                      side_bar_column: [{
                                          id: cF,
                                          goto: "ogv",
                                          track_id: d,
                                          pos: b,
                                          card_type: u,
                                          card_type_en: cG,
                                          cover: "https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fbangumi\u002Fimage\u002F983a2ad0799d4df0e54e5b2c1ce3600fc89afed7.jpg",
                                          url: cH,
                                          title: cI,
                                          sub_title: "最纯粹的网游体验",
                                          duration: Z,
                                          stats: {
                                              follow: _,
                                              view: $,
                                              danmaku: 75391,
                                              reply: 12682,
                                              coin: 59358,
                                              series_follow: cJ,
                                              series_view: $,
                                              likes: 348027,
                                              favorite: _
                                          },
                                          room_info: c,
                                          new_ep: {
                                              id: 810837,
                                              index_show: cK,
                                              cover: "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Farchive\u002Fed73e7e05219c6813e327e93f4807e2a249004d7.png",
                                              title: "11",
                                              long_title: "真正的光辉",
                                              pub_time: "2024-01-14 18:00:01",
                                              duration: Z,
                                              day_of_week: v
                                          },
                                          styles: ["热血", "奇幻", "科幻", "战斗", "漫画改"],
                                          comic: c,
                                          producer: [{
                                              mid: 928123,
                                              name: "哔哩哔哩番剧",
                                              type: o,
                                              is_contribute: b
                                          }],
                                          source: d,
                                          av_feature: c,
                                          is_rec: a,
                                          is_finish: a,
                                          is_started: b,
                                          is_play: b,
                                          horizontal_cover_16_9: cL,
                                          horizontal_cover_16_10: "https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fbangumi\u002Fimage\u002F7d432776abf4093b2d66f3a8c4fa198487a79e5b.jpg",
                                          enable_vt: a,
                                          vt_display: d
                                      }],
                                      business_card: c,
                                      floor_info: [{
                                          id: x,
                                          name: cM,
                                          rows: b
                                      }, {
                                          id: t,
                                          name: u,
                                          rows: b
                                      }, {
                                          id: q,
                                          name: aa,
                                          rows: b
                                      }, {
                                          id: cN,
                                          name: cO,
                                          rows: b
                                      }, {
                                          id: cP,
                                          name: cQ,
                                          rows: b
                                      }, {
                                          id: o,
                                          name: cR,
                                          rows: b
                                      }, {
                                          id: w,
                                          name: cS,
                                          rows: b
                                      }, {
                                          id: v,
                                          name: cT,
                                          rows: b
                                      }],
                                      user_feature: c,
                                      preload_expose_pct: I,
                                      preload_floor_expose_pct: I,
                                      mid: 51218333
                                  },
                                  recommendInline: {},
                                  head: {
                                      floorInfo: [{
                                          id: -2,
                                          sidebar: f,
                                          class: g,
                                          main: {
                                              type: "EvaCardList",
                                              head: {
                                                  icon: "ChannelSpread",
                                                  name: "推广"
                                              },
                                              params: {
                                                  id: 34
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: x,
                                          sidebar: f,
                                          class: "bili-grid no-margin",
                                          main: {
                                              type: "BattleArea",
                                              head: {
                                                  icon: "ChannelCompetition",
                                                  name: cM,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fgame\u002Fmatch\u002F"
                                              },
                                              params: {
                                                  id: 3449
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: b,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: "LiveCardList",
                                              head: {
                                                  icon: "ChannelLive",
                                                  name: "直播",
                                                  link: "https:\u002F\u002Flive.bilibili.com\u002F"
                                              }
                                          },
                                          aside: {
                                              type: "LiveRankList"
                                          },
                                          rows: b
                                      }, {
                                          id: K,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelDouga",
                                                  name: "动画",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fdouga"
                                              },
                                              params: {
                                                  rid: b
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fdouga"
                                              },
                                              params: {
                                                  rid: b
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: t,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: "BangumiArea",
                                              head: {
                                                  icon: "ChannelAnime",
                                                  name: u,
                                                  alias: u,
                                                  link: cU
                                              },
                                              params: {
                                                  season_type: b
                                              },
                                              bottom: {
                                                  aside: {
                                                      head: {
                                                          name: i,
                                                          class: j,
                                                          link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fbangumi",
                                                          report: {
                                                              name: u,
                                                              id: t
                                                          }
                                                      },
                                                      params: {
                                                          season_type: b
                                                      }
                                                  },
                                                  class: g,
                                                  main: {
                                                      head: {
                                                          id: -20001,
                                                          name: "番剧动态",
                                                          link: cU
                                                      }
                                                  }
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: q,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: "GuoChuangArea",
                                              head: {
                                                  icon: "ChannelGuochuang",
                                                  name: aa,
                                                  alias: "国产动画",
                                                  link: cV
                                              },
                                              params: {
                                                  season_type: q
                                              },
                                              extra: {
                                                  aside: {
                                                      head: {
                                                          name: i,
                                                          class: j,
                                                          link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fguochan",
                                                          report: {
                                                              name: aa,
                                                              id: q
                                                          }
                                                      },
                                                      params: {
                                                          season_type: q
                                                      }
                                                  }
                                              },
                                              bottom: {
                                                  class: g,
                                                  main: {
                                                      type: m,
                                                      head: {
                                                          id: -40001,
                                                          name: "国产原创相关",
                                                          link: cV
                                                      },
                                                      params: {
                                                          rid: cW
                                                      }
                                                  },
                                                  aside: {
                                                      head: {
                                                          name: i,
                                                          class: j,
                                                          link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fguochuang"
                                                      },
                                                      params: {
                                                          rid: cW
                                                      }
                                                  }
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: cX,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: "VarietyArea",
                                              head: {
                                                  icon: "ChannelZongyi",
                                                  name: "综艺",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fvariety\u002F"
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: cN,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: "MangaCardList",
                                              head: {
                                                  icon: "ChannelManhua",
                                                  name: cO,
                                                  link: "https:\u002F\u002Fmanga.bilibili.com\u002F"
                                              }
                                          },
                                          aside: {
                                              type: "MangaRankList"
                                          },
                                          rows: b
                                      }, {
                                          id: H,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelMusic",
                                                  name: "音乐",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fmusic"
                                              },
                                              params: {
                                                  rid: o
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fmusic"
                                              },
                                              params: {
                                                  rid: o
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: J,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelDance",
                                                  name: "舞蹈",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fdance"
                                              },
                                              params: {
                                                  rid: cY
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fdance"
                                              },
                                              params: {
                                                  rid: cY
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: cZ,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelGame",
                                                  name: "游戏",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fgame"
                                              },
                                              params: {
                                                  rid: q
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fgame"
                                              },
                                              params: {
                                                  rid: q
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: 12,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelKnowledge",
                                                  name: "知识",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fknowledge"
                                              },
                                              params: {
                                                  rid: c_
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fknowledge"
                                              },
                                              params: {
                                                  rid: c_
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: cP,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: "CheeseCardList",
                                              head: {
                                                  icon: "ChannelZhishi",
                                                  name: cQ,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fcheese"
                                              }
                                          },
                                          aside: {
                                              type: "CheeseRankList",
                                              head: {
                                                  name: i,
                                                  class: j
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: 13,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelTech",
                                                  name: "科技",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Ftech"
                                              },
                                              params: {
                                                  rid: c$
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Ftech"
                                              },
                                              params: {
                                                  rid: c$
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: 14,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelSports",
                                                  name: "运动",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fsports"
                                              },
                                              params: {
                                                  rid: da
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fsports"
                                              },
                                              params: {
                                                  rid: da
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: 15,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelCar",
                                                  name: "汽车",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fcar"
                                              },
                                              params: {
                                                  rid: db
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fcar"
                                              },
                                              params: {
                                                  rid: db
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: 16,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelLife",
                                                  name: "生活",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Flife"
                                              },
                                              params: {
                                                  rid: dc
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Flife"
                                              },
                                              params: {
                                                  rid: dc
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: 17,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelFood",
                                                  name: "美食",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Ffood"
                                              },
                                              params: {
                                                  rid: dd
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Ffood"
                                              },
                                              params: {
                                                  rid: dd
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: 18,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelAnimal",
                                                  name: "动物圈",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fanimal"
                                              },
                                              params: {
                                                  rid: de
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fanimal"
                                              },
                                              params: {
                                                  rid: de
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: 20,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelKichiku",
                                                  name: "鬼畜",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fkichiku"
                                              },
                                              params: {
                                                  rid: df
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fkichiku"
                                              },
                                              params: {
                                                  rid: df
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: 22,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelFashion",
                                                  name: "时尚",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Ffashion"
                                              },
                                              params: {
                                                  rid: dg
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Ffashion"
                                              },
                                              params: {
                                                  rid: dg
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: 21,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: "InformationArea",
                                              head: {
                                                  icon: "ChannelInformation",
                                                  name: "资讯",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Finformation"
                                              },
                                              params: {
                                                  rid: 202
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: dh,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelEnt",
                                                  name: "娱乐",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fent"
                                              },
                                              params: {
                                                  rid: w
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fent"
                                              },
                                              params: {
                                                  rid: w
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: 26,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: "ArticleCardList",
                                              head: {
                                                  icon: "ChannelRead",
                                                  name: "专栏",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fread\u002Fhome"
                                              }
                                          },
                                          aside: {
                                              type: "ArticleRankList",
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fread\u002Franking#type=3"
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: o,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: ab,
                                              head: {
                                                  icon: "ChannelMovie",
                                                  name: cR,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fmovie\u002F"
                                              },
                                              params: {
                                                  rid: dh
                                              }
                                          },
                                          aside: {
                                              type: ac,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fmovie"
                                              },
                                              params: {
                                                  season_type: t
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: w,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: ab,
                                              head: {
                                                  icon: "ChannelTeleplay",
                                                  name: cS,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Ftv\u002F"
                                              },
                                              params: {
                                                  rid: cZ
                                              }
                                          },
                                          aside: {
                                              type: ac,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Ftv"
                                              },
                                              params: {
                                                  season_type: w
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: 25,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: m,
                                              head: {
                                                  icon: "ChannelCinephile",
                                                  name: "影视",
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fcinephile"
                                              },
                                              params: {
                                                  rid: di
                                              }
                                          },
                                          aside: {
                                              type: n,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fcinephile"
                                              },
                                              params: {
                                                  rid: di
                                              }
                                          },
                                          rows: b
                                      }, {
                                          id: v,
                                          sidebar: e,
                                          class: g,
                                          main: {
                                              type: ab,
                                              head: {
                                                  icon: "ChannelDocumentary",
                                                  name: cT,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fdocumentary\u002F"
                                              },
                                              params: {
                                                  rid: 177
                                              }
                                          },
                                          aside: {
                                              type: ac,
                                              head: {
                                                  name: i,
                                                  class: j,
                                                  link: "https:\u002F\u002Fwww.bilibili.com\u002Fv\u002Fpopular\u002Frank\u002Fdocumentary"
                                              },
                                              params: {
                                                  season_type: o
                                              }
                                          },
                                          rows: b
                                      }],
                                      business: [],
                                      banner_card: {},
                                      recommend: [{
                                          freshIdx: a,
                                          goto: l,
                                          title: as,
                                          aid: y,
                                          cid: ap,
                                          bvid: ao,
                                          cover: M,
                                          pic: M,
                                          pic_4_3: ar,
                                          pubdate: au,
                                          enable_vt: a,
                                          author: {
                                              name: aw,
                                              mid: av,
                                              face: ax
                                          },
                                          isAd: f,
                                          url: aq,
                                          spaceUrl: "\u002F\u002Fspace.bilibili.com\u002F480804525",
                                          stats: {
                                              view: ay,
                                              like: az,
                                              danmaku: H,
                                              vt: a,
                                              vt_display: d
                                          },
                                          duration: at,
                                          spmInfo: {
                                              spmid: r,
                                              mod: s,
                                              idx: b
                                          },
                                          isFollowed: e,
                                          rcmdReason: {
                                              content: h,
                                              reason_type: b
                                          },
                                          showInfo: e,
                                          track_id: k,
                                          key: y,
                                          locId: p,
                                          freshType: a
                                      }, {
                                          freshIdx: a,
                                          goto: l,
                                          title: aE,
                                          aid: z,
                                          cid: aB,
                                          bvid: aA,
                                          cover: N,
                                          pic: N,
                                          pic_4_3: aD,
                                          pubdate: aG,
                                          enable_vt: a,
                                          author: {
                                              name: aI,
                                              mid: aH,
                                              face: aJ
                                          },
                                          isAd: f,
                                          url: aC,
                                          spaceUrl: "\u002F\u002Fspace.bilibili.com\u002F3493079208168355",
                                          stats: {
                                              view: aK,
                                              like: aL,
                                              danmaku: aM,
                                              vt: a,
                                              vt_display: d
                                          },
                                          duration: aF,
                                          spmInfo: {
                                              spmid: r,
                                              mod: s,
                                              idx: t
                                          },
                                          isFollowed: f,
                                          rcmdReason: {
                                              content: aN,
                                              reason_type: o
                                          },
                                          showInfo: e,
                                          track_id: k,
                                          key: z,
                                          locId: p,
                                          freshType: a
                                      }, {
                                          freshIdx: a,
                                          goto: l,
                                          title: aS,
                                          aid: A,
                                          cid: aP,
                                          bvid: aO,
                                          cover: O,
                                          pic: O,
                                          pic_4_3: aR,
                                          pubdate: aU,
                                          enable_vt: a,
                                          author: {
                                              name: aW,
                                              mid: aV,
                                              face: aX
                                          },
                                          isAd: f,
                                          url: aQ,
                                          spaceUrl: "\u002F\u002Fspace.bilibili.com\u002F378885845",
                                          stats: {
                                              view: aY,
                                              like: aZ,
                                              danmaku: a_,
                                              vt: a,
                                              vt_display: d
                                          },
                                          duration: aT,
                                          spmInfo: {
                                              spmid: r,
                                              mod: s,
                                              idx: o
                                          },
                                          isFollowed: f,
                                          rcmdReason: {
                                              content: h,
                                              reason_type: a
                                          },
                                          showInfo: e,
                                          track_id: k,
                                          key: A,
                                          locId: p,
                                          freshType: a
                                      }, {
                                          freshIdx: a,
                                          goto: l,
                                          title: bd,
                                          aid: B,
                                          cid: ba,
                                          bvid: a$,
                                          cover: P,
                                          pic: P,
                                          pic_4_3: bc,
                                          pubdate: bf,
                                          enable_vt: a,
                                          author: {
                                              name: bh,
                                              mid: bg,
                                              face: bi
                                          },
                                          isAd: f,
                                          url: bb,
                                          spaceUrl: "\u002F\u002Fspace.bilibili.com\u002F520819684",
                                          stats: {
                                              view: bj,
                                              like: bk,
                                              danmaku: bl,
                                              vt: a,
                                              vt_display: d
                                          },
                                          duration: be,
                                          spmInfo: {
                                              spmid: r,
                                              mod: s,
                                              idx: q
                                          },
                                          isFollowed: f,
                                          rcmdReason: {
                                              content: h,
                                              reason_type: a
                                          },
                                          showInfo: e,
                                          track_id: k,
                                          key: B,
                                          locId: p,
                                          freshType: a
                                      }, {
                                          locId: p,
                                          title: Q,
                                          aid: h,
                                          bvid: h,
                                          cid: h,
                                          cover: bn,
                                          author: {
                                              name: bq,
                                              mid: h,
                                              face: h
                                          },
                                          isAd: e,
                                          enable_vt: h,
                                          url: R,
                                          spaceUrl: R,
                                          pubdate: h,
                                          stats: {
                                              view: h,
                                              like: h,
                                              coin: h,
                                              danmaku: h,
                                              vt: h,
                                              vt_display: h
                                          },
                                          duration: h,
                                          spmInfo: {
                                              mod: "extension",
                                              idx: "content",
                                              ext: "click"
                                          },
                                          is_ad_loc: e,
                                          creative_id: S,
                                          show_url: h,
                                          src_id: L,
                                          server: h,
                                          is_ad: e,
                                          operater: d,
                                          res_id: a,
                                          asg_id: a,
                                          area: a,
                                          ad_cb: bp,
                                          pos_num: b,
                                          mid: d,
                                          resource_id: h,
                                          server_type: b,
                                          id: a,
                                          card_type: a,
                                          business_mark: br,
                                          request_id: bo,
                                          goto: bm,
                                          key: S,
                                          freshType: a
                                      }, {
                                          freshIdx: a,
                                          goto: l,
                                          title: bx,
                                          aid: C,
                                          cid: bu,
                                          bvid: bt,
                                          cover: U,
                                          pic: U,
                                          pic_4_3: bw,
                                          pubdate: bz,
                                          enable_vt: a,
                                          author: {
                                              name: bB,
                                              mid: bA,
                                              face: bC
                                          },
                                          isAd: f,
                                          url: bv,
                                          spaceUrl: "\u002F\u002Fspace.bilibili.com\u002F293753863",
                                          stats: {
                                              view: bD,
                                              like: bE,
                                              danmaku: bF,
                                              vt: a,
                                              vt_display: d
                                          },
                                          duration: by,
                                          spmInfo: {
                                              spmid: r,
                                              mod: s,
                                              idx: cX
                                          },
                                          isFollowed: f,
                                          rcmdReason: {
                                              content: h,
                                              reason_type: a
                                          },
                                          showInfo: e,
                                          track_id: k,
                                          key: C,
                                          locId: p,
                                          freshType: a
                                      }, {
                                          freshIdx: a,
                                          goto: l,
                                          title: bK,
                                          aid: D,
                                          cid: bH,
                                          bvid: bG,
                                          cover: V,
                                          pic: V,
                                          pic_4_3: bJ,
                                          pubdate: bM,
                                          enable_vt: a,
                                          author: {
                                              name: bO,
                                              mid: bN,
                                              face: bP
                                          },
                                          isAd: f,
                                          url: bI,
                                          spaceUrl: "\u002F\u002Fspace.bilibili.com\u002F19319172",
                                          stats: {
                                              view: bQ,
                                              like: bR,
                                              danmaku: bS,
                                              vt: a,
                                              vt_display: d
                                          },
                                          duration: bL,
                                          spmInfo: {
                                              spmid: r,
                                              mod: s,
                                              idx: v
                                          },
                                          isFollowed: f,
                                          rcmdReason: {
                                              content: h,
                                              reason_type: a
                                          },
                                          showInfo: e,
                                          track_id: k,
                                          key: D,
                                          locId: p,
                                          freshType: a
                                      }, {
                                          freshIdx: a,
                                          goto: l,
                                          title: bX,
                                          aid: E,
                                          cid: bU,
                                          bvid: bT,
                                          cover: W,
                                          pic: W,
                                          pic_4_3: bW,
                                          pubdate: bZ,
                                          enable_vt: a,
                                          author: {
                                              name: b$,
                                              mid: b_,
                                              face: ca
                                          },
                                          isAd: f,
                                          url: bV,
                                          spaceUrl: "\u002F\u002Fspace.bilibili.com\u002F2100737396",
                                          stats: {
                                              view: cb,
                                              like: cc,
                                              danmaku: cd,
                                              vt: a,
                                              vt_display: d
                                          },
                                          duration: bY,
                                          spmInfo: {
                                              spmid: r,
                                              mod: s,
                                              idx: K
                                          },
                                          isFollowed: e,
                                          rcmdReason: {
                                              content: h,
                                              reason_type: b
                                          },
                                          showInfo: e,
                                          track_id: k,
                                          key: E,
                                          locId: p,
                                          freshType: a
                                      }, {
                                          freshIdx: a,
                                          goto: l,
                                          title: ci,
                                          aid: F,
                                          cid: cf,
                                          bvid: ce,
                                          cover: X,
                                          pic: X,
                                          pic_4_3: ch,
                                          pubdate: ck,
                                          enable_vt: a,
                                          author: {
                                              name: cm,
                                              mid: cl,
                                              face: cn
                                          },
                                          isAd: f,
                                          url: cg,
                                          spaceUrl: "\u002F\u002Fspace.bilibili.com\u002F75480955",
                                          stats: {
                                              view: co,
                                              like: cp,
                                              danmaku: cq,
                                              vt: a,
                                              vt_display: d
                                          },
                                          duration: cj,
                                          spmInfo: {
                                              spmid: r,
                                              mod: s,
                                              idx: H
                                          },
                                          isFollowed: f,
                                          rcmdReason: {
                                              content: cr,
                                              reason_type: o
                                          },
                                          showInfo: e,
                                          track_id: k,
                                          key: F,
                                          locId: p,
                                          freshType: a
                                      }, {
                                          freshIdx: a,
                                          goto: l,
                                          title: cw,
                                          aid: G,
                                          cid: ct,
                                          bvid: cs,
                                          cover: Y,
                                          pic: Y,
                                          pic_4_3: cv,
                                          pubdate: cy,
                                          enable_vt: a,
                                          author: {
                                              name: cA,
                                              mid: cz,
                                              face: cB
                                          },
                                          isAd: f,
                                          url: cu,
                                          spaceUrl: "\u002F\u002Fspace.bilibili.com\u002F37607457",
                                          stats: {
                                              view: cC,
                                              like: cD,
                                              danmaku: cE,
                                              vt: a,
                                              vt_display: d
                                          },
                                          duration: cx,
                                          spmInfo: {
                                              spmid: r,
                                              mod: s,
                                              idx: J
                                          },
                                          isFollowed: f,
                                          rcmdReason: {
                                              content: h,
                                              reason_type: a
                                          },
                                          showInfo: e,
                                          track_id: k,
                                          key: G,
                                          locId: p,
                                          freshType: a
                                      }],
                                      aside_card: {
                                          goto: cG,
                                          ai_params: {
                                              pos: b,
                                              track_id: d,
                                              av_feature: c,
                                              source: d,
                                              is_rec: a
                                          },
                                          displayItem: {
                                              pic: cL,
                                              url: cH,
                                              title: cI,
                                              isWatched: f,
                                              subTitle: cK,
                                              id: cF,
                                              duration: Z,
                                              day_of_week: v,
                                              author: {},
                                              enable_vt: a,
                                              stats: {
                                                  danmaku: a,
                                                  view: $,
                                                  like: cJ,
                                                  favorite: _,
                                                  share: a,
                                                  vt: a,
                                                  vt_display: d,
                                                  online: a,
                                                  area: d
                                              }
                                          },
                                          freshType: a
                                      },
                                      ad: [],
                                      preload_expose_pct: I,
                                      preload_floor_expose_pct: I
                                  },
                                  dynamicUpList: [],
                                  specialRcmdFloor: [],
                                  haveFetchSpecialRcmdFloor: f
                              }
                          }
                      }
                  }(0, 1, null, "", true, false, "bili-grid", void 0, "排行榜", "rank-title", "web_pegasus_9.router-web-pegasus-1397555-6d9cf9d4f8-ntzdr.1705300832111.179", "av", "VideoCardList", "VideoRankList", 3, 5613, 4, "333.851", "b_7265636f6d6d656e64", 2, "番剧", 7, 5, -1, 368054110, 236892856, 278714067, 793230179, 368084374, 326130779, 792873475, 793678795, 878690552, 9, .5, 10, 8, 5614, "http:\u002F\u002Fi1.hdslb.com\u002Fbfs\u002Farchive\u002F8afeca095852e09a27f4582a68eec80f4b92d509.jpg", "http:\u002F\u002Fi2.hdslb.com\u002Fbfs\u002Farchive\u002Ff701e95d15811acc36629d1ba158ed6b085efa2e.jpg", "http:\u002F\u002Fi1.hdslb.com\u002Fbfs\u002Farchive\u002F65479f1ba228b11160459bc70cfc70c08ff55729.jpg", "http:\u002F\u002Fi1.hdslb.com\u002Fbfs\u002Farchive\u002F9ac7edc74640a7fd50fecafd410cc71145fc2f2b.jpg", "互动，测一测留学生回国薪资能有多少？", "https:\u002F\u002Fgaoneng.bilibili.com\u002Ftetris\u002Fpage\u002F?pageId=832303904134623232&pre_render_global=0&auto_media_playback=1&navhide=0&buvid=__BUVID__&mid=__MID__&imei=__IMEI__&duid=__DUID__&idfa=__IDFA__&android_id=__ANDROIDID__&os=3&request_id=1705300832108q172a25a163a109q2568&source_id=5614&track_id=pbaes.TgqHxU3OBEgtPP_gUKO4X43p3EwiASSBuepvg80FDhPy7FgA5zCLArdxkdxhK4AECABj2iLrVVtKDV-7hTTqIP4vdWkTqHcCiLC5WyqnxvGz4ss47RjrNNU5mGUiXDT3Xl7ZqDbsdiI5qyJEtGB6CGMc02GfMWpGDF5jL4aYLK1XhdUGewyQ7y0FDNGBc6jZ&creative_id=121799182&adtype=CPC", 121799182, "#999999FF", "http:\u002F\u002Fi2.hdslb.com\u002Fbfs\u002Farchive\u002Fe0d9c7ef28a0db2b94c9d28fb322aacfe5480d27.jpg", "http:\u002F\u002Fi1.hdslb.com\u002Fbfs\u002Farchive\u002F4c01bd69933cd4cc378e18a7edaba9813044ea07.jpg", "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Farchive\u002F9f2c169cbb17190f551e6573bbd20d3e05f7a891.jpg", "http:\u002F\u002Fi1.hdslb.com\u002Fbfs\u002Farchive\u002F1df78e1aba85dd51095b53157e050853ca6e558a.jpg", "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Farchive\u002F1d2c849a53ef5004c707d830c4da0b57502569ce.jpg", 1416000, 709760, 34104067, "国创", "MovieCardList", "PgcRankList", "V_FAVOR_WATCH_LATER", {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, "BV1U94y1u77T", 1387249124, "https:\u002F\u002Fwww.bilibili.com\u002Fvideo\u002FBV1U94y1u77T", "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Faistory\u002F2023-12-30-1747154000368054110_16_12_2973_crop.jpg", "2023年度 - 编程相关书籍回顾与推荐", 874, 1703929634, 480804525, "__阿岳__", "https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fface\u002Fb7f37702448fdd61a7101765201b8ff1fe3caf86.jpg", 9592, 442, "BV1ie411o79T", 1360337986, "https:\u002F\u002Fwww.bilibili.com\u002Fvideo\u002FBV1ie411o79T", "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Faistory\u002F2023-12-10-180020236892856_1612_gener.jpg", "【王维MBTI】16型人格的情感需求｜部分cp向｜全员向动画", 1135, 1702202400, 3493079208168355, "王维诗里的MBTI", "https:\u002F\u002Fi1.hdslb.com\u002Fbfs\u002Fface\u002F7178fa2ca173ccc07700b6dc44d99139c0332295.jpg", 469941, 37663, 5934, "3万点赞", "BV1Pw411P7C9", 1340409405, "https:\u002F\u002Fwww.bilibili.com\u002Fvideo\u002FBV1Pw411P7C9", "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Faistory\u002F2023-11-22-143320278714067_1612_gener.jpg", "锐评刚满18岁事件，被性丑化的人真的很恶心", 382, 1700634797, 378885845, "不正经老丝", "https:\u002F\u002Fi2.hdslb.com\u002Fbfs\u002Fface\u002F542becaf0f3d5edbc69d7f51f917ffaf75b5c448.jpg", 4361083, 99070, 8183, "BV1uC4y1q79G", 1389872626, "https:\u002F\u002Fwww.bilibili.com\u002Fvideo\u002FBV1uC4y1q79G", "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Farchive\u002F9ac7edc74640a7fd50fecafd410cc71145fc2f2b.jpg", "【硬核】一口气了解美联储 | 全球权力最大的金融机构", 1463, 1704101400, 520819684, "小Lin说", "https:\u002F\u002Fi1.hdslb.com\u002Fbfs\u002Fface\u002Fcf895b86c955e4ce62b28b3c2bb5bbc77f9fd410.jpg", 2002464, 113552, 11617, "ad", "https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fsycp\u002Fcreative_img\u002F202311\u002Fa4d44b79f9b4aa088fdac4aaf18fee69.jpg", "1705300832108q172a25a163a109q2568", "CKXW9QEQqZ24CRiOhIo6IMQIKAIw4el8OO4rQiExNzA1MzAwODMyMTA4cTE3MmEyNWExNjNhMTA5cTI1NjhI7N7m3tAxUgnlsJrkvanmgalaD+S8iuWIqeivuuS8iuW3nmIG576O5Zu9aAFwAXiAgICAkBiAAQOIAQCSAQ42Ni4yNTMuMTgzLjIzNqABpQmoAQSyASBEQ0xznUPOB6FJXJIxqoWhU9mhVDAz8xJ2tR3XMA3ehroBiARodHRwczovL2dhb25lbmcuYmlsaWJpbGkuY29tL3RldHJpcy9wYWdlLz9wYWdlSWQ9ODMyMzAzOTA0MTM0NjIzMjMyJnByZV9yZW5kZXJfZ2xvYmFsPTAmYXV0b19tZWRpYV9wbGF5YmFjaz0xJm5hdmhpZGU9MCZidXZpZD1fX0JVVklEX18mbWlkPV9fTUlEX18maW1laT1fX0lNRUlfXyZkdWlkPV9fRFVJRF9fJmlkZmE9X19JREZBX18mYW5kcm9pZF9pZD1fX0FORFJPSURJRF9fJm9zPTMmcmVxdWVzdF9pZD0xNzA1MzAwODMyMTA4cTE3MmEyNWExNjNhMTA5cTI1Njgmc291cmNlX2lkPTU2MTQmdHJhY2tfaWQ9cGJhZXMuVGdxSHhVM09CRWd0UFBfZ1VLTzRYNDNwM0V3aUFTU0J1ZXB2ZzgwRkRoUHk3RmdBNXpDTEFyZHhrZHhoSzRBRUNBQmoyaUxyVlZ0S0RWLTdoVFRxSVA0dmRXa1RxSGNDaUxDNVd5cW54dkd6NHNzNDdSanJOTlU1bUdVaVhEVDNYbDdacURic2RpSTVxeUpFdEdCNkNHTWMwMkdmTVdwR0RGNWpMNGFZTEsxWGhkVUdld3lRN3kwRkROR0JjNmpaJmNyZWF0aXZlX2lkPTEyMTc5OTE4MiZhZHR5cGU9Q1BDwgECMTXSAQDYAcEB4AGAlOvcA+gBgK3iBPABAPgBxAiAAgKIAgCSAo8DMjExMzIzODFfMTcwNTI4OTQ0MywyMjIyMTA0Nl8xNzA1MjkwMDA1LDIyMjIxNTc2XzE3MDUyOTAxMjEsMjE4NzY4MTVfMTcwNTI5MDIyMiwyMTk1MjE2MV8xNzA1MjkwMzQwLDIxOTQ0Njg0XzE3MDUyOTA0ODAsMjE4MTc3NTlfMTcwNTI4OTQxNSwyMjE5MDExMl8xNzA1MjkwOTA0LDIyMDg1NzYzXzE3MDUzMDA0ODcsMjE5MTUzNzZfMTcwNTMwMDQ5NSwyMjE5MDMzNl8xNzA1MzAwNDY3LDE5ODcyMTM4XzE3MDUzMDA1NDEsMTYxMjI1MjZfMTcwNTMwMDU0MSwyMTg3ODEwOV8xNzA1MzAwNjUzLDIyMDgzMDk2XzE3MDUzMDA2NjgsMjIxODc5MzdfMTcwNTMwMDc0MywxOTg0MTUwNF8xNzA1MzAwNzg0LDE5NDQwNDEyXzE3MDUzMDA1MDEsMjIxODkyODVfMTcwNTMwMDczNywyMTUxODc4MV8xNzA1MzAwODI3mAKClcwEoALCH6gCiekEsAIkuAIAwALgpxLIArYF6gIA+ALzK4gDBJIDAKgDALADALgDAMgDK9IDkAF7IjEiOiIxMjE3OTkxODIiLCIxMiI6IjU2MTQiLCIxMyI6IjI4NTgyNSIsIjE0IjoiNDc2IiwiMTUiOiI0OTMiLCIxNiI6IjI4NTgyNV81NjE5IiwiMiI6IjIwNDUxNTMiLCIzIjoiMjA0NTE1MyIsIjQiOiI2MyIsIjUiOiI2NyIsIjYiOiIyMDQ1MTUzIn3gAwLoAwXwAwD6AwVvdGhlcoIECW51bGw6bnVsbIgEpQmQBACgBCKqBAcInNDHBBAEqgQHCMPTywQQAbgECsAEBNAEANgEAOIEmAE1Ni57InBzSWQiOjE3MjE1LCJ2MiI6IlhrYngzQi0tNmlOQlM1c3J6SmZCa2l3aVpMa0JqZ250em1lZElhdHZuWmdJTmgzZ1dHYjFiWkkzMFJPdE1RaU9tZGl3OFZWdHR6UUFtLUdSWDJFWTROLWNMeE5LVk9GdE9WSSJ9OzYzLnsicHNJZCI6MTY3NTgsInYyIjoiZkEifegEAPAEgOD1uNv\u002Fu8YL+gTbAXsiYml6X3R5cGUiOjQsImNwYSI6IntcImNwYV9sZXZlbFwiOjIsXCJjcGFfc2V0XCI6MTI4MDB9IiwiZXhwbG9yZV9yYXRpbyI6IjEwMCIsIm1vZGVsU2NvcmUiOiJ7XCJjdHJcIjpcIjQuMDM2NTA5XCIsXCJjdnJfbDBcIjpcIjY5NC40MjU4NDJcIixcImZpbmFsX3BjdHJcIjpcIjQuMDM2NTA5XCIsXCJmaW5hbF9wY3ZyXCI6XCI2OTQuNDI1ODQyXCJ9IiwidmlkZW9fdXBfbWlkIjowfYAFAJAFKJAFM5AFQ5AFSJAFSZAFYpAFcpAFhAGQBYYBkAWIAZAFiQGQBYwBkAWsAZAFsQGQBbMBkAW0AZAFyAGQBdABkAXRAZAF1wGQBdgBkAXoAZAF8QGQBYkCkAWOApAFmAKQBZoCkAWdApAFngKQBakCkAWqApAFswKQBbcCkAXAApAFwgKQBcMCkAXFApAFywKQBcwCkAXOApAF0wKQBdYCkAXXApAF2AKQBdkCkAXaApAF3AKQBd8CkAXhApAF4wKQBeQCkAXlApAF5gKQBfACkAX1ApAF+wKQBf8CkAWGA5AFjQOQBZIDkAWUA5AFlQOQBZgDkAWZA5AFmgOQBZsDkAWcA5AFoAOQBaEDkAWiA5AFpAOQBaUDkAWnA5AFsAOQBbEDkAW2A5AFtwOQBcADkAXBA5AFzQOQBdMDkAXXA5AF4AOQBeUDkAXoA5AF6gOQBesDkAXyA5AF9QOQBfcDkAX4A5AF\u002FwOQBYAEkAWrBJAFrwSQBbAEkAWxBJAFsgSQBbQEkAW4BJAF5QS4BQTABYG5EcgFAg==", "TogoCareer", {}, "#686868", "BV1f94y1u7ti", 1387214978, "https:\u002F\u002Fwww.bilibili.com\u002Fvideo\u002FBV1f94y1u7ti", "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Faistory\u002F2023-12-31-101007368084374_1612_gener.jpg", "谨以此片献给每一位热爱原神的玩家！【耗时𝟏年高质量努力制作】", 2836, 1703988600, 293753863, "伊零Onezero", "https:\u002F\u002Fi1.hdslb.com\u002Fbfs\u002Fface\u002F289fdba3e9b70f86d7690c4182cbb3fbc4998c41.jpg", 1071962, 88257, 2611, "BV16w411E74S", 1404148128, "https:\u002F\u002Fwww.bilibili.com\u002Fvideo\u002FBV16w411E74S", "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Faistory\u002F2024-01-13-1418554699326130779_16_12_9242_crop.jpg", "火遍全网的“工业大摸底”，堪称新时代的手撕鬼子【差评君】", 640, 1705062778, 19319172, "差评君", "https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fface\u002F229599e175faafa1855c0f103d512e8b469b5aad.jpg", 1733036, 106555, 6377, "BV1QC4y1q7FS", 1381696927, "https:\u002F\u002Fwww.bilibili.com\u002Fvideo\u002FBV1QC4y1q7FS", "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Faistory\u002F2023-12-26-2000433273792873475_16_12_7888_crop.jpg", "核心训练详解", 446, 1703592000, 2100737396, "凯圣王", "https:\u002F\u002Fi2.hdslb.com\u002Fbfs\u002Fface\u002Fb5b7f01e0078c41a89070a88fd08c2afdd8d2d6b.jpg", 44343, 3379, 59, "BV1KC4y1e7rF", 1404900083, "https:\u002F\u002Fwww.bilibili.com\u002Fvideo\u002FBV1KC4y1e7rF", "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Farchive\u002F1df78e1aba85dd51095b53157e050853ca6e558a.jpg", "雪衣全程单通黄金与机械难题12，主播打完直接昏厥！三十年来最爽的一把！", 1413, 1705117672, 75480955, "念熙阿", "https:\u002F\u002Fi1.hdslb.com\u002Fbfs\u002Fface\u002Fe6f59d002049d48c0151920bf9a5168b970b567e.jpg", 603841, 49704, 2205, "4万点赞", "BV1cN4y1i7h3", 1404557854, "https:\u002F\u002Fwww.bilibili.com\u002Fvideo\u002FBV1cN4y1i7h3", "http:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Faistory\u002F2024-01-13-100032575878690552_16_12_844_crop.jpg", "《哆啦A梦》小夫家究竟有多富？直接造一个实体版来研究", 613, 1705111200, 37607457, "凹凸赛克", "https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fface\u002F0ef80337464d68ff5303e056c8ae2a7d03131228.jpg", 414497, 48671, 1171, 46086, "bangumi", "https:\u002F\u002Fwww.bilibili.com\u002Fbangumi\u002Fplay\u002Fss46086", "香格里拉边境", 709758, "更新至第11话", "https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fbangumi\u002Fimage\u002Fd815e287f1429dea158e7c440b1518e0dad92226.jpg", "赛事", 28, "漫画", 27, "课堂", "电影", "电视剧", "纪录片", "https:\u002F\u002Fwww.bilibili.com\u002Fanime\u002F", "https:\u002F\u002Fwww.bilibili.com\u002Fguochuang\u002F", 168, 6, 129, 11, 36, 188, 234, 223, 160, 211, 217, 119, 155, 23, 181))
              </script>
              <script type="text/javascript" src="//s1.hdslb.com/bfs/cm/cm-sdk/static/js/pc.js"></script>
              <script nomodule>
                  !function() {
                      var e = document
                        , t = e.createElement("script");
                      if (!("noModule"in t) && "onbeforeload"in t) {
                          var n = !1;
                          e.addEventListener("beforeload", (function(e) {
                              if (e.target === t)
                                  n = !0;
                              else if (!e.target.hasAttribute("nomodule") || !n)
                                  return;
                              e.preventDefault()
                          }
                          ), !0),
                          t.type = "module",
                          t.src = ".",
                          e.head.appendChild(t),
                          t.remove()
                      }
                  }();
              </script>
              <script nomodule id="vite-legacy-polyfill" src="//s1.hdslb.com/bfs/static/laputa-home/client/assets/polyfills-legacy.6f129f8c.js"></script>
              <script nomodule id="vite-legacy-entry" data-src="//s1.hdslb.com/bfs/static/laputa-home/client/assets/index-legacy.d93c4610.js">
                  System.import(document.getElementById('vite-legacy-entry').getAttribute('data-src'))
              </script>
          </body>
      </html>
      
      ```

      