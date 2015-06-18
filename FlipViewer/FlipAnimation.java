



<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" >
 
 <meta name="ROBOTS" content="NOARCHIVE">
 
 <link rel="icon" type="image/vnd.microsoft.icon" href="https://ssl.gstatic.com/codesite/ph/images/phosting.ico">
 
 
 <script type="text/javascript">
 
 
 
 
 var codesite_token = "ABZ6GAeV9_Zxb4N785Ocqv2SZ_lmHtxVDw:1434264997523";
 
 
 var CS_env = {"domainName": null, "assetHostPath": "https://ssl.gstatic.com/codesite/ph", "relativeBaseUrl": "", "loggedInUserEmail": "potatothezero@gmail.com", "projectName": "android-3d-flip-view-transition", "projectHomeUrl": "/p/android-3d-flip-view-transition", "token": "ABZ6GAeV9_Zxb4N785Ocqv2SZ_lmHtxVDw:1434264997523", "profileUrl": "/u/107328840504307469604/", "assetVersionPath": "https://ssl.gstatic.com/codesite/ph/8599073060794244502"};
 var _gaq = _gaq || [];
 _gaq.push(
 ['siteTracker._setAccount', 'UA-18071-1'],
 ['siteTracker._trackPageview']);
 
 _gaq.push(
 ['projectTracker._setAccount', 'UA-7657526-5'],
 ['projectTracker._trackPageview']);
 
 (function() {
 var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
 ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
 (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(ga);
 })();
 
 </script>
 
 
 <title>FlipAnimation.java - 
 android-3d-flip-view-transition -
 
 
 A 3D view flip transition for Android - Google Project Hosting
 </title>
 <link type="text/css" rel="stylesheet" href="https://ssl.gstatic.com/codesite/ph/8599073060794244502/css/core.css">
 
 <link type="text/css" rel="stylesheet" href="https://ssl.gstatic.com/codesite/ph/8599073060794244502/css/ph_detail.css" >
 
 
 <link type="text/css" rel="stylesheet" href="https://ssl.gstatic.com/codesite/ph/8599073060794244502/css/d_sb.css" >
 
 
 
<!--[if IE]>
 <link type="text/css" rel="stylesheet" href="https://ssl.gstatic.com/codesite/ph/8599073060794244502/css/d_ie.css" >
<![endif]-->
 <style type="text/css">
 .menuIcon.off { background: no-repeat url(https://ssl.gstatic.com/codesite/ph/images/dropdown_sprite.gif) 0 -42px }
 .menuIcon.on { background: no-repeat url(https://ssl.gstatic.com/codesite/ph/images/dropdown_sprite.gif) 0 -28px }
 .menuIcon.down { background: no-repeat url(https://ssl.gstatic.com/codesite/ph/images/dropdown_sprite.gif) 0 0; }
 
 
 
  tr.inline_comment {
 background: #fff;
 vertical-align: top;
 }
 div.draft, div.published {
 padding: .3em;
 border: 1px solid #999; 
 margin-bottom: .1em;
 font-family: arial, sans-serif;
 max-width: 60em;
 }
 div.draft {
 background: #ffa;
 } 
 div.published {
 background: #e5ecf9;
 }
 div.published .body, div.draft .body {
 padding: .5em .1em .1em .1em;
 max-width: 60em;
 white-space: pre-wrap;
 white-space: -moz-pre-wrap;
 white-space: -pre-wrap;
 white-space: -o-pre-wrap;
 word-wrap: break-word;
 font-size: 1em;
 }
 div.draft .actions {
 margin-left: 1em;
 font-size: 90%;
 }
 div.draft form {
 padding: .5em .5em .5em 0;
 }
 div.draft textarea, div.published textarea {
 width: 95%;
 height: 10em;
 font-family: arial, sans-serif;
 margin-bottom: .5em;
 }

 
 .nocursor, .nocursor td, .cursor_hidden, .cursor_hidden td {
 background-color: white;
 height: 2px;
 }
 .cursor, .cursor td {
 background-color: darkblue;
 height: 2px;
 display: '';
 }
 
 
.list {
 border: 1px solid white;
 border-bottom: 0;
}

 
 </style>
</head>
<body class="t4">
<script type="text/javascript">
 window.___gcfg = {lang: 'en'};
 (function() 
 {var po = document.createElement("script");
 po.type = "text/javascript"; po.async = true;po.src = "https://apis.google.com/js/plusone.js";
 var s = document.getElementsByTagName("script")[0];
 s.parentNode.insertBefore(po, s);
 })();
</script>
<div class="headbg">

 <div id="gaia">
 

 <span>
 
 
 
 <a href="#" id="multilogin-dropdown" onclick="return false;"
 ><u><b>potatothezero@gmail.com</b></u> <small>&#9660;</small></a>
 
 
 | <a href="/u/107328840504307469604/" id="projects-dropdown" onclick="return false;"
 ><u>My favorites</u> <small>&#9660;</small></a>
 | <a href="/u/107328840504307469604/" onclick="_CS_click('/gb/ph/profile');"
 title="Profile, Updates, and Settings"
 ><u>Profile</u></a>
 | <a href="https://www.google.com/accounts/Logout?continue=https%3A%2F%2Fcode.google.com%2Fp%2Fandroid-3d-flip-view-transition%2Fsource%2Fbrowse%2Ftrunk%2Fsrc%2Fcom%2Ftekle%2Foss%2Fandroid%2Fanimation%2FFlipAnimation.java" 
 onclick="_CS_click('/gb/ph/signout');"
 ><u>Sign out</u></a>
 
 </span>

 </div>

 <div class="gbh" style="left: 0pt;"></div>
 <div class="gbh" style="right: 0pt;"></div>
 
 
 <div style="height: 1px"></div>
<!--[if lte IE 7]>
<div style="text-align:center;">
Your version of Internet Explorer is not supported. Try a browser that
contributes to open source, such as <a href="http://www.firefox.com">Firefox</a>,
<a href="http://www.google.com/chrome">Google Chrome</a>, or
<a href="http://code.google.com/chrome/chromeframe/">Google Chrome Frame</a>.
</div>
<![endif]-->



 <table style="padding:0px; margin: 0px 0px 10px 0px; width:100%" cellpadding="0" cellspacing="0"
 itemscope itemtype="http://schema.org/CreativeWork">
 <tr style="height: 58px;">
 
 
 
 <td id="plogo">
 <link itemprop="url" href="/p/android-3d-flip-view-transition">
 <a href="/p/android-3d-flip-view-transition/">
 
 
 <img src="/p/android-3d-flip-view-transition/logo?cct=1327966448"
 alt="Logo" itemprop="image">
 
 </a>
 </td>
 
 <td style="padding-left: 0.5em">
 
 <div id="pname">
 <a href="/p/android-3d-flip-view-transition/"><span itemprop="name">android-3d-flip-view-transition</span></a>
 </div>
 
 <div id="psum">
 <a id="project_summary_link"
 href="/p/android-3d-flip-view-transition/"><span itemprop="description">A 3D view flip transition for Android</span></a>
 
 </div>
 
 
 </td>
 <td style="white-space:nowrap;text-align:right; vertical-align:bottom;">
 
 <form action="/hosting/search">
 <input size="30" name="q" value="" type="text">
 
 <input type="submit" name="projectsearch" value="Search projects" >
 </form>
 
 </tr>
 </table>

</div>

 
<div id="mt" class="gtb"> 
 <a href="/p/android-3d-flip-view-transition/" class="tab ">Project&nbsp;Home</a>
 
 
 
 
 
 
 <a href="/p/android-3d-flip-view-transition/w/list" class="tab ">Wiki</a>
 
 
 
 
 
 <a href="/p/android-3d-flip-view-transition/issues/list"
 class="tab ">Issues</a>
 
 
 
 
 
 <a href="/p/android-3d-flip-view-transition/source/checkout"
 class="tab active">Source</a>
 
 
 
 
 
 
 
 
 <a href="https://code.google.com/export-to-github/export?project=android-3d-flip-view-transition">
 <button>Export to GitHub</button>
 
 </a>
 
 
 
 
 
 <div class=gtbc></div>
</div>
<table cellspacing="0" cellpadding="0" width="100%" align="center" border="0" class="st">
 <tr>
 
 
 
 
 
 
 <td class="subt">
 <div class="st2">
 <div class="isf">
 
 


 <span class="inst1"><a href="/p/android-3d-flip-view-transition/source/checkout">Checkout</a></span> &nbsp;
 <span class="inst2"><a href="/p/android-3d-flip-view-transition/source/browse/">Browse</a></span> &nbsp;
 <span class="inst3"><a href="/p/android-3d-flip-view-transition/source/list">Changes</a></span> &nbsp;
 
 
 
 
 
 
 
 </form>
 <script type="text/javascript">
 
 function codesearchQuery(form) {
 var query = document.getElementById('q').value;
 if (query) { form.action += '%20' + query; }
 }
 </script>
 </div>
</div>

 </td>
 
 
 
 <td align="right" valign="top" class="bevel-right"></td>
 </tr>
</table>


<script type="text/javascript">
 var cancelBubble = false;
 function _go(url) { document.location = url; }
</script>
<div id="maincol"
 
>

 




<div class="expand">
<div id="colcontrol">
<style type="text/css">
 #file_flipper { white-space: nowrap; padding-right: 2em; }
 #file_flipper.hidden { display: none; }
 #file_flipper .pagelink { color: #0000CC; text-decoration: underline; }
 #file_flipper #visiblefiles { padding-left: 0.5em; padding-right: 0.5em; }
</style>
<table id="nav_and_rev" class="list"
 cellpadding="0" cellspacing="0" width="100%">
 <tr>
 
 <td nowrap="nowrap" class="src_crumbs src_nav" width="33%">
 <strong class="src_nav">Source path:&nbsp;</strong>
 <span id="crumb_root">
 
 <a href="/p/android-3d-flip-view-transition/source/browse/">svn</a>/&nbsp;</span>
 <span id="crumb_links" class="ifClosed"><a href="/p/android-3d-flip-view-transition/source/browse/trunk/">trunk</a><span class="sp">/&nbsp;</span><a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/">src</a><span class="sp">/&nbsp;</span><a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/">com</a><span class="sp">/&nbsp;</span><a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/">tekle</a><span class="sp">/&nbsp;</span><a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/">oss</a><span class="sp">/&nbsp;</span><a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/">android</a><span class="sp">/&nbsp;</span><a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/animation/">animation</a><span class="sp">/&nbsp;</span>FlipAnimation.java</span>
 
 


 </td>
 
 
 <td nowrap="nowrap" width="33%" align="center">
 <a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/animation/FlipAnimation.java?edit=1"
 ><img src="https://ssl.gstatic.com/codesite/ph/images/pencil-y14.png"
 class="edit_icon">Edit file</a>
 </td>
 
 
 <td nowrap="nowrap" width="33%" align="right">
 <table cellpadding="0" cellspacing="0" style="font-size: 100%"><tr>
 
 
 <td class="flipper"><b>r4</b></td>
 
 </tr></table>
 </td> 
 </tr>
</table>

<div class="fc">
 
 
 
<style type="text/css">
.undermouse span {
 background-image: url(https://ssl.gstatic.com/codesite/ph/images/comments.gif); }
</style>
<table class="opened" id="review_comment_area"
><tr>
<td id="nums">
<pre><table width="100%"><tr class="nocursor"><td></td></tr></table></pre>
<pre><table width="100%" id="nums_table_0"><tr id="gr_svn4_1"

><td id="1"><a href="#1">1</a></td></tr
><tr id="gr_svn4_2"

><td id="2"><a href="#2">2</a></td></tr
><tr id="gr_svn4_3"

><td id="3"><a href="#3">3</a></td></tr
><tr id="gr_svn4_4"

><td id="4"><a href="#4">4</a></td></tr
><tr id="gr_svn4_5"

><td id="5"><a href="#5">5</a></td></tr
><tr id="gr_svn4_6"

><td id="6"><a href="#6">6</a></td></tr
><tr id="gr_svn4_7"

><td id="7"><a href="#7">7</a></td></tr
><tr id="gr_svn4_8"

><td id="8"><a href="#8">8</a></td></tr
><tr id="gr_svn4_9"

><td id="9"><a href="#9">9</a></td></tr
><tr id="gr_svn4_10"

><td id="10"><a href="#10">10</a></td></tr
><tr id="gr_svn4_11"

><td id="11"><a href="#11">11</a></td></tr
><tr id="gr_svn4_12"

><td id="12"><a href="#12">12</a></td></tr
><tr id="gr_svn4_13"

><td id="13"><a href="#13">13</a></td></tr
><tr id="gr_svn4_14"

><td id="14"><a href="#14">14</a></td></tr
><tr id="gr_svn4_15"

><td id="15"><a href="#15">15</a></td></tr
><tr id="gr_svn4_16"

><td id="16"><a href="#16">16</a></td></tr
><tr id="gr_svn4_17"

><td id="17"><a href="#17">17</a></td></tr
><tr id="gr_svn4_18"

><td id="18"><a href="#18">18</a></td></tr
><tr id="gr_svn4_19"

><td id="19"><a href="#19">19</a></td></tr
><tr id="gr_svn4_20"

><td id="20"><a href="#20">20</a></td></tr
><tr id="gr_svn4_21"

><td id="21"><a href="#21">21</a></td></tr
><tr id="gr_svn4_22"

><td id="22"><a href="#22">22</a></td></tr
><tr id="gr_svn4_23"

><td id="23"><a href="#23">23</a></td></tr
><tr id="gr_svn4_24"

><td id="24"><a href="#24">24</a></td></tr
><tr id="gr_svn4_25"

><td id="25"><a href="#25">25</a></td></tr
><tr id="gr_svn4_26"

><td id="26"><a href="#26">26</a></td></tr
><tr id="gr_svn4_27"

><td id="27"><a href="#27">27</a></td></tr
><tr id="gr_svn4_28"

><td id="28"><a href="#28">28</a></td></tr
><tr id="gr_svn4_29"

><td id="29"><a href="#29">29</a></td></tr
><tr id="gr_svn4_30"

><td id="30"><a href="#30">30</a></td></tr
><tr id="gr_svn4_31"

><td id="31"><a href="#31">31</a></td></tr
><tr id="gr_svn4_32"

><td id="32"><a href="#32">32</a></td></tr
><tr id="gr_svn4_33"

><td id="33"><a href="#33">33</a></td></tr
><tr id="gr_svn4_34"

><td id="34"><a href="#34">34</a></td></tr
><tr id="gr_svn4_35"

><td id="35"><a href="#35">35</a></td></tr
><tr id="gr_svn4_36"

><td id="36"><a href="#36">36</a></td></tr
><tr id="gr_svn4_37"

><td id="37"><a href="#37">37</a></td></tr
><tr id="gr_svn4_38"

><td id="38"><a href="#38">38</a></td></tr
><tr id="gr_svn4_39"

><td id="39"><a href="#39">39</a></td></tr
><tr id="gr_svn4_40"

><td id="40"><a href="#40">40</a></td></tr
><tr id="gr_svn4_41"

><td id="41"><a href="#41">41</a></td></tr
><tr id="gr_svn4_42"

><td id="42"><a href="#42">42</a></td></tr
><tr id="gr_svn4_43"

><td id="43"><a href="#43">43</a></td></tr
><tr id="gr_svn4_44"

><td id="44"><a href="#44">44</a></td></tr
><tr id="gr_svn4_45"

><td id="45"><a href="#45">45</a></td></tr
><tr id="gr_svn4_46"

><td id="46"><a href="#46">46</a></td></tr
><tr id="gr_svn4_47"

><td id="47"><a href="#47">47</a></td></tr
><tr id="gr_svn4_48"

><td id="48"><a href="#48">48</a></td></tr
><tr id="gr_svn4_49"

><td id="49"><a href="#49">49</a></td></tr
><tr id="gr_svn4_50"

><td id="50"><a href="#50">50</a></td></tr
><tr id="gr_svn4_51"

><td id="51"><a href="#51">51</a></td></tr
><tr id="gr_svn4_52"

><td id="52"><a href="#52">52</a></td></tr
><tr id="gr_svn4_53"

><td id="53"><a href="#53">53</a></td></tr
><tr id="gr_svn4_54"

><td id="54"><a href="#54">54</a></td></tr
><tr id="gr_svn4_55"

><td id="55"><a href="#55">55</a></td></tr
><tr id="gr_svn4_56"

><td id="56"><a href="#56">56</a></td></tr
><tr id="gr_svn4_57"

><td id="57"><a href="#57">57</a></td></tr
><tr id="gr_svn4_58"

><td id="58"><a href="#58">58</a></td></tr
><tr id="gr_svn4_59"

><td id="59"><a href="#59">59</a></td></tr
><tr id="gr_svn4_60"

><td id="60"><a href="#60">60</a></td></tr
><tr id="gr_svn4_61"

><td id="61"><a href="#61">61</a></td></tr
><tr id="gr_svn4_62"

><td id="62"><a href="#62">62</a></td></tr
><tr id="gr_svn4_63"

><td id="63"><a href="#63">63</a></td></tr
><tr id="gr_svn4_64"

><td id="64"><a href="#64">64</a></td></tr
><tr id="gr_svn4_65"

><td id="65"><a href="#65">65</a></td></tr
><tr id="gr_svn4_66"

><td id="66"><a href="#66">66</a></td></tr
><tr id="gr_svn4_67"

><td id="67"><a href="#67">67</a></td></tr
><tr id="gr_svn4_68"

><td id="68"><a href="#68">68</a></td></tr
><tr id="gr_svn4_69"

><td id="69"><a href="#69">69</a></td></tr
><tr id="gr_svn4_70"

><td id="70"><a href="#70">70</a></td></tr
><tr id="gr_svn4_71"

><td id="71"><a href="#71">71</a></td></tr
><tr id="gr_svn4_72"

><td id="72"><a href="#72">72</a></td></tr
><tr id="gr_svn4_73"

><td id="73"><a href="#73">73</a></td></tr
><tr id="gr_svn4_74"

><td id="74"><a href="#74">74</a></td></tr
><tr id="gr_svn4_75"

><td id="75"><a href="#75">75</a></td></tr
><tr id="gr_svn4_76"

><td id="76"><a href="#76">76</a></td></tr
><tr id="gr_svn4_77"

><td id="77"><a href="#77">77</a></td></tr
><tr id="gr_svn4_78"

><td id="78"><a href="#78">78</a></td></tr
><tr id="gr_svn4_79"

><td id="79"><a href="#79">79</a></td></tr
><tr id="gr_svn4_80"

><td id="80"><a href="#80">80</a></td></tr
><tr id="gr_svn4_81"

><td id="81"><a href="#81">81</a></td></tr
><tr id="gr_svn4_82"

><td id="82"><a href="#82">82</a></td></tr
><tr id="gr_svn4_83"

><td id="83"><a href="#83">83</a></td></tr
><tr id="gr_svn4_84"

><td id="84"><a href="#84">84</a></td></tr
><tr id="gr_svn4_85"

><td id="85"><a href="#85">85</a></td></tr
><tr id="gr_svn4_86"

><td id="86"><a href="#86">86</a></td></tr
><tr id="gr_svn4_87"

><td id="87"><a href="#87">87</a></td></tr
><tr id="gr_svn4_88"

><td id="88"><a href="#88">88</a></td></tr
><tr id="gr_svn4_89"

><td id="89"><a href="#89">89</a></td></tr
><tr id="gr_svn4_90"

><td id="90"><a href="#90">90</a></td></tr
><tr id="gr_svn4_91"

><td id="91"><a href="#91">91</a></td></tr
><tr id="gr_svn4_92"

><td id="92"><a href="#92">92</a></td></tr
><tr id="gr_svn4_93"

><td id="93"><a href="#93">93</a></td></tr
><tr id="gr_svn4_94"

><td id="94"><a href="#94">94</a></td></tr
><tr id="gr_svn4_95"

><td id="95"><a href="#95">95</a></td></tr
><tr id="gr_svn4_96"

><td id="96"><a href="#96">96</a></td></tr
><tr id="gr_svn4_97"

><td id="97"><a href="#97">97</a></td></tr
><tr id="gr_svn4_98"

><td id="98"><a href="#98">98</a></td></tr
><tr id="gr_svn4_99"

><td id="99"><a href="#99">99</a></td></tr
><tr id="gr_svn4_100"

><td id="100"><a href="#100">100</a></td></tr
><tr id="gr_svn4_101"

><td id="101"><a href="#101">101</a></td></tr
><tr id="gr_svn4_102"

><td id="102"><a href="#102">102</a></td></tr
><tr id="gr_svn4_103"

><td id="103"><a href="#103">103</a></td></tr
><tr id="gr_svn4_104"

><td id="104"><a href="#104">104</a></td></tr
><tr id="gr_svn4_105"

><td id="105"><a href="#105">105</a></td></tr
><tr id="gr_svn4_106"

><td id="106"><a href="#106">106</a></td></tr
><tr id="gr_svn4_107"

><td id="107"><a href="#107">107</a></td></tr
><tr id="gr_svn4_108"

><td id="108"><a href="#108">108</a></td></tr
><tr id="gr_svn4_109"

><td id="109"><a href="#109">109</a></td></tr
><tr id="gr_svn4_110"

><td id="110"><a href="#110">110</a></td></tr
><tr id="gr_svn4_111"

><td id="111"><a href="#111">111</a></td></tr
><tr id="gr_svn4_112"

><td id="112"><a href="#112">112</a></td></tr
><tr id="gr_svn4_113"

><td id="113"><a href="#113">113</a></td></tr
><tr id="gr_svn4_114"

><td id="114"><a href="#114">114</a></td></tr
><tr id="gr_svn4_115"

><td id="115"><a href="#115">115</a></td></tr
><tr id="gr_svn4_116"

><td id="116"><a href="#116">116</a></td></tr
><tr id="gr_svn4_117"

><td id="117"><a href="#117">117</a></td></tr
><tr id="gr_svn4_118"

><td id="118"><a href="#118">118</a></td></tr
><tr id="gr_svn4_119"

><td id="119"><a href="#119">119</a></td></tr
><tr id="gr_svn4_120"

><td id="120"><a href="#120">120</a></td></tr
><tr id="gr_svn4_121"

><td id="121"><a href="#121">121</a></td></tr
><tr id="gr_svn4_122"

><td id="122"><a href="#122">122</a></td></tr
><tr id="gr_svn4_123"

><td id="123"><a href="#123">123</a></td></tr
><tr id="gr_svn4_124"

><td id="124"><a href="#124">124</a></td></tr
><tr id="gr_svn4_125"

><td id="125"><a href="#125">125</a></td></tr
><tr id="gr_svn4_126"

><td id="126"><a href="#126">126</a></td></tr
><tr id="gr_svn4_127"

><td id="127"><a href="#127">127</a></td></tr
><tr id="gr_svn4_128"

><td id="128"><a href="#128">128</a></td></tr
><tr id="gr_svn4_129"

><td id="129"><a href="#129">129</a></td></tr
><tr id="gr_svn4_130"

><td id="130"><a href="#130">130</a></td></tr
><tr id="gr_svn4_131"

><td id="131"><a href="#131">131</a></td></tr
><tr id="gr_svn4_132"

><td id="132"><a href="#132">132</a></td></tr
><tr id="gr_svn4_133"

><td id="133"><a href="#133">133</a></td></tr
><tr id="gr_svn4_134"

><td id="134"><a href="#134">134</a></td></tr
><tr id="gr_svn4_135"

><td id="135"><a href="#135">135</a></td></tr
><tr id="gr_svn4_136"

><td id="136"><a href="#136">136</a></td></tr
><tr id="gr_svn4_137"

><td id="137"><a href="#137">137</a></td></tr
><tr id="gr_svn4_138"

><td id="138"><a href="#138">138</a></td></tr
><tr id="gr_svn4_139"

><td id="139"><a href="#139">139</a></td></tr
><tr id="gr_svn4_140"

><td id="140"><a href="#140">140</a></td></tr
><tr id="gr_svn4_141"

><td id="141"><a href="#141">141</a></td></tr
><tr id="gr_svn4_142"

><td id="142"><a href="#142">142</a></td></tr
><tr id="gr_svn4_143"

><td id="143"><a href="#143">143</a></td></tr
><tr id="gr_svn4_144"

><td id="144"><a href="#144">144</a></td></tr
><tr id="gr_svn4_145"

><td id="145"><a href="#145">145</a></td></tr
><tr id="gr_svn4_146"

><td id="146"><a href="#146">146</a></td></tr
><tr id="gr_svn4_147"

><td id="147"><a href="#147">147</a></td></tr
><tr id="gr_svn4_148"

><td id="148"><a href="#148">148</a></td></tr
><tr id="gr_svn4_149"

><td id="149"><a href="#149">149</a></td></tr
><tr id="gr_svn4_150"

><td id="150"><a href="#150">150</a></td></tr
><tr id="gr_svn4_151"

><td id="151"><a href="#151">151</a></td></tr
><tr id="gr_svn4_152"

><td id="152"><a href="#152">152</a></td></tr
><tr id="gr_svn4_153"

><td id="153"><a href="#153">153</a></td></tr
><tr id="gr_svn4_154"

><td id="154"><a href="#154">154</a></td></tr
><tr id="gr_svn4_155"

><td id="155"><a href="#155">155</a></td></tr
><tr id="gr_svn4_156"

><td id="156"><a href="#156">156</a></td></tr
><tr id="gr_svn4_157"

><td id="157"><a href="#157">157</a></td></tr
><tr id="gr_svn4_158"

><td id="158"><a href="#158">158</a></td></tr
><tr id="gr_svn4_159"

><td id="159"><a href="#159">159</a></td></tr
><tr id="gr_svn4_160"

><td id="160"><a href="#160">160</a></td></tr
></table></pre>
<pre><table width="100%"><tr class="nocursor"><td></td></tr></table></pre>
</td>
<td id="lines">
<pre><table width="100%"><tr class="cursor_stop cursor_hidden"><td></td></tr></table></pre>
<pre class="prettyprint lang-java"><table id="src_table_0"><tr
id=sl_svn4_1

><td class="source">/**<br></td></tr
><tr
id=sl_svn4_2

><td class="source"> * Copyright (c) 2012 Ephraim Tekle genzeb@gmail.com<br></td></tr
><tr
id=sl_svn4_3

><td class="source"> * <br></td></tr
><tr
id=sl_svn4_4

><td class="source"> * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and <br></td></tr
><tr
id=sl_svn4_5

><td class="source"> * associated documentation files (the &quot;Software&quot;), to deal in the Software without restriction, including <br></td></tr
><tr
id=sl_svn4_6

><td class="source"> * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell <br></td></tr
><tr
id=sl_svn4_7

><td class="source"> * copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the <br></td></tr
><tr
id=sl_svn4_8

><td class="source"> * following conditions:<br></td></tr
><tr
id=sl_svn4_9

><td class="source"> * <br></td></tr
><tr
id=sl_svn4_10

><td class="source"> * The above copyright notice and this permission notice shall be included in all copies or substantial <br></td></tr
><tr
id=sl_svn4_11

><td class="source"> * portions of the Software.<br></td></tr
><tr
id=sl_svn4_12

><td class="source"> * <br></td></tr
><tr
id=sl_svn4_13

><td class="source"> * THE SOFTWARE IS PROVIDED &quot;AS IS&quot;, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT <br></td></tr
><tr
id=sl_svn4_14

><td class="source"> * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN <br></td></tr
><tr
id=sl_svn4_15

><td class="source"> * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, <br></td></tr
><tr
id=sl_svn4_16

><td class="source"> * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE <br></td></tr
><tr
id=sl_svn4_17

><td class="source"> * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.<br></td></tr
><tr
id=sl_svn4_18

><td class="source"> * <br></td></tr
><tr
id=sl_svn4_19

><td class="source"> *  @author Ephraim A. Tekle<br></td></tr
><tr
id=sl_svn4_20

><td class="source"> *<br></td></tr
><tr
id=sl_svn4_21

><td class="source"> */<br></td></tr
><tr
id=sl_svn4_22

><td class="source">package com.tekle.oss.android.animation;<br></td></tr
><tr
id=sl_svn4_23

><td class="source"><br></td></tr
><tr
id=sl_svn4_24

><td class="source">import android.view.animation.Animation;<br></td></tr
><tr
id=sl_svn4_25

><td class="source">import android.graphics.Camera;<br></td></tr
><tr
id=sl_svn4_26

><td class="source">import android.graphics.Matrix; <br></td></tr
><tr
id=sl_svn4_27

><td class="source">import android.view.animation.Transformation;<br></td></tr
><tr
id=sl_svn4_28

><td class="source"><br></td></tr
><tr
id=sl_svn4_29

><td class="source">/**  <br></td></tr
><tr
id=sl_svn4_30

><td class="source"> * This class extends Animation to support a 3D flip view transition animation. Two instances of this class is <br></td></tr
><tr
id=sl_svn4_31

><td class="source"> * required: one for the &quot;from&quot; view and another for the &quot;to&quot; view. <br></td></tr
><tr
id=sl_svn4_32

><td class="source"> * <br></td></tr
><tr
id=sl_svn4_33

><td class="source"> * NOTE: use {@link AnimationFactory} to use this class.<br></td></tr
><tr
id=sl_svn4_34

><td class="source"> * <br></td></tr
><tr
id=sl_svn4_35

><td class="source"> *  @author Ephraim A. Tekle<br></td></tr
><tr
id=sl_svn4_36

><td class="source"> *<br></td></tr
><tr
id=sl_svn4_37

><td class="source"> */<br></td></tr
><tr
id=sl_svn4_38

><td class="source">public class FlipAnimation extends Animation { <br></td></tr
><tr
id=sl_svn4_39

><td class="source">	private final float mFromDegrees;<br></td></tr
><tr
id=sl_svn4_40

><td class="source">	private final float mToDegrees;<br></td></tr
><tr
id=sl_svn4_41

><td class="source">	private final float mCenterX;<br></td></tr
><tr
id=sl_svn4_42

><td class="source">	private final float mCenterY;<br></td></tr
><tr
id=sl_svn4_43

><td class="source">	private Camera mCamera;<br></td></tr
><tr
id=sl_svn4_44

><td class="source">	<br></td></tr
><tr
id=sl_svn4_45

><td class="source">	private final ScaleUpDownEnum scaleType;<br></td></tr
><tr
id=sl_svn4_46

><td class="source">	 <br></td></tr
><tr
id=sl_svn4_47

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_48

><td class="source">	 * How much to scale up/down. The default scale of 75% of full size seems optimal based on testing. Feel free to experiment away, however.<br></td></tr
><tr
id=sl_svn4_49

><td class="source">	 */ <br></td></tr
><tr
id=sl_svn4_50

><td class="source">	public static final float SCALE_DEFAULT = 0.75f;<br></td></tr
><tr
id=sl_svn4_51

><td class="source">	<br></td></tr
><tr
id=sl_svn4_52

><td class="source">	private float scale;<br></td></tr
><tr
id=sl_svn4_53

><td class="source"><br></td></tr
><tr
id=sl_svn4_54

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_55

><td class="source">	 * Constructs a new {@code FlipAnimation} object.Two {@code FlipAnimation} objects are needed for a complete transition b/n two views. <br></td></tr
><tr
id=sl_svn4_56

><td class="source">	 * <br></td></tr
><tr
id=sl_svn4_57

><td class="source">	 * @param fromDegrees the start angle in degrees for a rotation along the y-axis, i.e. in-and-out of the screen, i.e. 3D flip. This should really be multiple of 90 degrees.<br></td></tr
><tr
id=sl_svn4_58

><td class="source">	 * @param toDegrees the end angle in degrees for a rotation along the y-axis, i.e. in-and-out of the screen, i.e. 3D flip. This should really be multiple of 90 degrees.<br></td></tr
><tr
id=sl_svn4_59

><td class="source">	 * @param centerX the x-axis value of the center of rotation<br></td></tr
><tr
id=sl_svn4_60

><td class="source">	 * @param centerY the y-axis value of the center of rotation<br></td></tr
><tr
id=sl_svn4_61

><td class="source">	 * @param scale to get a 3D effect, the transition views need to be zoomed (scaled). This value must be b/n (0,1) or else the default scale {@link #SCALE_DEFAULT} is used.<br></td></tr
><tr
id=sl_svn4_62

><td class="source">	 * @param scaleType flip view transition is broken down into two: the zoom-out of the &quot;from&quot; view and the zoom-in of the &quot;to&quot; view. This parameter is used to determine which is being done. See {@link ScaleUpDownEnum}.<br></td></tr
><tr
id=sl_svn4_63

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_64

><td class="source">	public FlipAnimation(float fromDegrees, float toDegrees, float centerX, float centerY, float scale, ScaleUpDownEnum scaleType) {<br></td></tr
><tr
id=sl_svn4_65

><td class="source">		mFromDegrees = fromDegrees;<br></td></tr
><tr
id=sl_svn4_66

><td class="source">		mToDegrees = toDegrees;<br></td></tr
><tr
id=sl_svn4_67

><td class="source">		mCenterX = centerX;<br></td></tr
><tr
id=sl_svn4_68

><td class="source">		mCenterY = centerY;<br></td></tr
><tr
id=sl_svn4_69

><td class="source">		this.scale = (scale&lt;=0||scale&gt;=1)?SCALE_DEFAULT:scale;<br></td></tr
><tr
id=sl_svn4_70

><td class="source">		this.scaleType = scaleType==null?ScaleUpDownEnum.SCALE_CYCLE:scaleType;<br></td></tr
><tr
id=sl_svn4_71

><td class="source">	}<br></td></tr
><tr
id=sl_svn4_72

><td class="source"><br></td></tr
><tr
id=sl_svn4_73

><td class="source">	@Override<br></td></tr
><tr
id=sl_svn4_74

><td class="source">	public void initialize(int width, int height, int parentWidth, int parentHeight) {<br></td></tr
><tr
id=sl_svn4_75

><td class="source">		super.initialize(width, height, parentWidth, parentHeight);<br></td></tr
><tr
id=sl_svn4_76

><td class="source">		mCamera = new Camera();<br></td></tr
><tr
id=sl_svn4_77

><td class="source">	}<br></td></tr
><tr
id=sl_svn4_78

><td class="source"><br></td></tr
><tr
id=sl_svn4_79

><td class="source">	@Override<br></td></tr
><tr
id=sl_svn4_80

><td class="source">	protected void applyTransformation(float interpolatedTime, Transformation t) {<br></td></tr
><tr
id=sl_svn4_81

><td class="source">		final float fromDegrees = mFromDegrees;<br></td></tr
><tr
id=sl_svn4_82

><td class="source">		float degrees = fromDegrees + ((mToDegrees - fromDegrees) * interpolatedTime);<br></td></tr
><tr
id=sl_svn4_83

><td class="source"><br></td></tr
><tr
id=sl_svn4_84

><td class="source">		final float centerX = mCenterX;<br></td></tr
><tr
id=sl_svn4_85

><td class="source">		final float centerY = mCenterY;<br></td></tr
><tr
id=sl_svn4_86

><td class="source">		final Camera camera = mCamera;<br></td></tr
><tr
id=sl_svn4_87

><td class="source"><br></td></tr
><tr
id=sl_svn4_88

><td class="source">		final Matrix matrix = t.getMatrix();<br></td></tr
><tr
id=sl_svn4_89

><td class="source"><br></td></tr
><tr
id=sl_svn4_90

><td class="source">		camera.save();<br></td></tr
><tr
id=sl_svn4_91

><td class="source"><br></td></tr
><tr
id=sl_svn4_92

><td class="source">		camera.rotateY(degrees); <br></td></tr
><tr
id=sl_svn4_93

><td class="source"><br></td></tr
><tr
id=sl_svn4_94

><td class="source">		camera.getMatrix(matrix);<br></td></tr
><tr
id=sl_svn4_95

><td class="source">		camera.restore();<br></td></tr
><tr
id=sl_svn4_96

><td class="source"><br></td></tr
><tr
id=sl_svn4_97

><td class="source">		matrix.preTranslate(-centerX, -centerY);<br></td></tr
><tr
id=sl_svn4_98

><td class="source">		matrix.postTranslate(centerX, centerY); <br></td></tr
><tr
id=sl_svn4_99

><td class="source">		<br></td></tr
><tr
id=sl_svn4_100

><td class="source">		matrix.preScale(scaleType.getScale(scale, interpolatedTime), scaleType.getScale(scale, interpolatedTime), centerX, centerY);<br></td></tr
><tr
id=sl_svn4_101

><td class="source"><br></td></tr
><tr
id=sl_svn4_102

><td class="source">	}<br></td></tr
><tr
id=sl_svn4_103

><td class="source"><br></td></tr
><tr
id=sl_svn4_104

><td class="source">	<br></td></tr
><tr
id=sl_svn4_105

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_106

><td class="source">	 * This enumeration is used to determine the zoom (or scale) behavior of a {@link FlipAnimation}.<br></td></tr
><tr
id=sl_svn4_107

><td class="source">	 * <br></td></tr
><tr
id=sl_svn4_108

><td class="source">	 * @author Ephraim A. Tekle <br></td></tr
><tr
id=sl_svn4_109

><td class="source">	 *<br></td></tr
><tr
id=sl_svn4_110

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_111

><td class="source">	public static enum ScaleUpDownEnum {<br></td></tr
><tr
id=sl_svn4_112

><td class="source">		/**<br></td></tr
><tr
id=sl_svn4_113

><td class="source">		 * The view will be scaled up from the scale value until it&#39;s at 100% zoom level (i.e. no zoom).<br></td></tr
><tr
id=sl_svn4_114

><td class="source">		 */<br></td></tr
><tr
id=sl_svn4_115

><td class="source">		SCALE_UP, <br></td></tr
><tr
id=sl_svn4_116

><td class="source">		/**<br></td></tr
><tr
id=sl_svn4_117

><td class="source">		 * The view will be scaled down starting at no zoom (100% zoom level) until it&#39;s at a specified zoom level.<br></td></tr
><tr
id=sl_svn4_118

><td class="source">		 */<br></td></tr
><tr
id=sl_svn4_119

><td class="source">		SCALE_DOWN, <br></td></tr
><tr
id=sl_svn4_120

><td class="source">		/**<br></td></tr
><tr
id=sl_svn4_121

><td class="source">		 * The view will cycle through a zoom down and then zoom up.<br></td></tr
><tr
id=sl_svn4_122

><td class="source">		 */<br></td></tr
><tr
id=sl_svn4_123

><td class="source">		SCALE_CYCLE, <br></td></tr
><tr
id=sl_svn4_124

><td class="source">		/**<br></td></tr
><tr
id=sl_svn4_125

><td class="source">		 * No zoom effect is applied.<br></td></tr
><tr
id=sl_svn4_126

><td class="source">		 */<br></td></tr
><tr
id=sl_svn4_127

><td class="source">		SCALE_NONE;<br></td></tr
><tr
id=sl_svn4_128

><td class="source">		<br></td></tr
><tr
id=sl_svn4_129

><td class="source">		/**<br></td></tr
><tr
id=sl_svn4_130

><td class="source">		 * The intermittent zoom level given the current or desired maximum zoom level for the specified iteration<br></td></tr
><tr
id=sl_svn4_131

><td class="source">		 * <br></td></tr
><tr
id=sl_svn4_132

><td class="source">		 * @param max the maximum desired or current zoom level<br></td></tr
><tr
id=sl_svn4_133

><td class="source">		 * @param iter the iteration (from 0..1).<br></td></tr
><tr
id=sl_svn4_134

><td class="source">		 * @return the current zoom level<br></td></tr
><tr
id=sl_svn4_135

><td class="source">		 */<br></td></tr
><tr
id=sl_svn4_136

><td class="source">		public float getScale(float max, float iter) {<br></td></tr
><tr
id=sl_svn4_137

><td class="source">			switch(this) {<br></td></tr
><tr
id=sl_svn4_138

><td class="source">			case SCALE_UP:<br></td></tr
><tr
id=sl_svn4_139

><td class="source">				return max +  (1-max)*iter;<br></td></tr
><tr
id=sl_svn4_140

><td class="source">				<br></td></tr
><tr
id=sl_svn4_141

><td class="source">			case SCALE_DOWN:<br></td></tr
><tr
id=sl_svn4_142

><td class="source">				return 1 - (1-max)*iter;<br></td></tr
><tr
id=sl_svn4_143

><td class="source">				<br></td></tr
><tr
id=sl_svn4_144

><td class="source">			case SCALE_CYCLE: { <br></td></tr
><tr
id=sl_svn4_145

><td class="source">				final boolean halfWay = (iter &gt; 0.5);  <br></td></tr
><tr
id=sl_svn4_146

><td class="source"><br></td></tr
><tr
id=sl_svn4_147

><td class="source">				if (halfWay) {<br></td></tr
><tr
id=sl_svn4_148

><td class="source">					return max +  (1-max)*(iter-0.5f)*2;<br></td></tr
><tr
id=sl_svn4_149

><td class="source">				} else {<br></td></tr
><tr
id=sl_svn4_150

><td class="source">					return 1 - (1-max)*(iter*2);<br></td></tr
><tr
id=sl_svn4_151

><td class="source">				}<br></td></tr
><tr
id=sl_svn4_152

><td class="source">			}<br></td></tr
><tr
id=sl_svn4_153

><td class="source">			<br></td></tr
><tr
id=sl_svn4_154

><td class="source">			default:<br></td></tr
><tr
id=sl_svn4_155

><td class="source">				return 1;<br></td></tr
><tr
id=sl_svn4_156

><td class="source">			}<br></td></tr
><tr
id=sl_svn4_157

><td class="source">		}<br></td></tr
><tr
id=sl_svn4_158

><td class="source">	}<br></td></tr
><tr
id=sl_svn4_159

><td class="source">	<br></td></tr
><tr
id=sl_svn4_160

><td class="source">}<br></td></tr
></table></pre>
<pre><table width="100%"><tr class="cursor_stop cursor_hidden"><td></td></tr></table></pre>
</td>
</tr></table>

 
<script type="text/javascript">
 var lineNumUnderMouse = -1;
 
 function gutterOver(num) {
 gutterOut();
 var newTR = document.getElementById('gr_svn4_' + num);
 if (newTR) {
 newTR.className = 'undermouse';
 }
 lineNumUnderMouse = num;
 }
 function gutterOut() {
 if (lineNumUnderMouse != -1) {
 var oldTR = document.getElementById(
 'gr_svn4_' + lineNumUnderMouse);
 if (oldTR) {
 oldTR.className = '';
 }
 lineNumUnderMouse = -1;
 }
 }
 var numsGenState = {table_base_id: 'nums_table_'};
 var srcGenState = {table_base_id: 'src_table_'};
 var alignerRunning = false;
 var startOver = false;
 function setLineNumberHeights() {
 if (alignerRunning) {
 startOver = true;
 return;
 }
 numsGenState.chunk_id = 0;
 numsGenState.table = document.getElementById('nums_table_0');
 numsGenState.row_num = 0;
 if (!numsGenState.table) {
 return; // Silently exit if no file is present.
 }
 srcGenState.chunk_id = 0;
 srcGenState.table = document.getElementById('src_table_0');
 srcGenState.row_num = 0;
 alignerRunning = true;
 continueToSetLineNumberHeights();
 }
 function rowGenerator(genState) {
 if (genState.row_num < genState.table.rows.length) {
 var currentRow = genState.table.rows[genState.row_num];
 genState.row_num++;
 return currentRow;
 }
 var newTable = document.getElementById(
 genState.table_base_id + (genState.chunk_id + 1));
 if (newTable) {
 genState.chunk_id++;
 genState.row_num = 0;
 genState.table = newTable;
 return genState.table.rows[0];
 }
 return null;
 }
 var MAX_ROWS_PER_PASS = 1000;
 function continueToSetLineNumberHeights() {
 var rowsInThisPass = 0;
 var numRow = 1;
 var srcRow = 1;
 while (numRow && srcRow && rowsInThisPass < MAX_ROWS_PER_PASS) {
 numRow = rowGenerator(numsGenState);
 srcRow = rowGenerator(srcGenState);
 rowsInThisPass++;
 if (numRow && srcRow) {
 if (numRow.offsetHeight != srcRow.offsetHeight) {
 numRow.firstChild.style.height = srcRow.offsetHeight + 'px';
 }
 }
 }
 if (rowsInThisPass >= MAX_ROWS_PER_PASS) {
 setTimeout(continueToSetLineNumberHeights, 10);
 } else {
 alignerRunning = false;
 if (startOver) {
 startOver = false;
 setTimeout(setLineNumberHeights, 500);
 }
 }
 }
 function initLineNumberHeights() {
 // Do 2 complete passes, because there can be races
 // between this code and prettify.
 startOver = true;
 setTimeout(setLineNumberHeights, 250);
 window.onresize = setLineNumberHeights;
 }
 initLineNumberHeights();
</script>

 
 
 <div id="log">
 <div style="text-align:right">
 <a class="ifCollapse" href="#" onclick="_toggleMeta(this); return false">Show details</a>
 <a class="ifExpand" href="#" onclick="_toggleMeta(this); return false">Hide details</a>
 </div>
 <div class="ifExpand">
 
 
 <div class="pmeta_bubble_bg" style="border:1px solid white">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <div id="changelog">
 <p>Change log</p>
 <div>
 <a href="/p/android-3d-flip-view-transition/source/detail?spec=svn4&amp;r=2">r2</a>
 by genzeb
 on Jan 30, 2012
 &nbsp; <a href="/p/android-3d-flip-view-transition/source/diff?spec=svn4&r=2&amp;format=side&amp;path=/trunk/src/com/tekle/oss/android/animation/FlipAnimation.java&amp;old_path=/trunk/src/com/tekle/oss/android/animation/FlipAnimation.java&amp;old=">Diff</a>
 </div>
 <pre>First commit to depot.</pre>
 </div>
 
 
 
 
 
 
 <script type="text/javascript">
 var detail_url = '/p/android-3d-flip-view-transition/source/detail?r=2&spec=svn4';
 var publish_url = '/p/android-3d-flip-view-transition/source/detail?r=2&spec=svn4#publish';
 // describe the paths of this revision in javascript.
 var changed_paths = [];
 var changed_urls = [];
 
 changed_paths.push('/trunk/.classpath');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/.classpath?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/.project');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/.project?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/AndroidManifest.xml');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/AndroidManifest.xml?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/assets');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/assets?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/bin');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/bin?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/default.properties');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/default.properties?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/gen');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/gen?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/gen/com');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/gen/com?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/gen/com/tekle');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/gen/com/tekle?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/gen/com/tekle/oss');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/gen/com/tekle/oss?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/gen/com/tekle/oss/android');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/gen/com/tekle/oss/android?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/gen/com/tekle/oss/android/flipviewtransition');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/gen/com/tekle/oss/android/flipviewtransition?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/gen/com/tekle/oss/android/flipviewtransition/R.java');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/gen/com/tekle/oss/android/flipviewtransition/R.java?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/proguard.cfg');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/proguard.cfg?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/drawable');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/drawable-hdpi');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable-hdpi?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/drawable-hdpi/icon.png');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable-hdpi/icon.png?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/drawable-ldpi');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable-ldpi?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/drawable-ldpi/icon.png');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable-ldpi/icon.png?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/drawable-mdpi');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable-mdpi?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/drawable-mdpi/icon.png');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable-mdpi/icon.png?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/drawable/grid.png');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable/grid.png?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/drawable/larrypage.png');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable/larrypage.png?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/drawable/larrypage_bio.png');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable/larrypage_bio.png?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/layout');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/layout?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/layout/main.xml');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/layout/main.xml?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/values');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/values?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/values/strings.xml');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/values/strings.xml?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/src');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/src?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/src/com');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/src/com?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/src/com/tekle');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/src/com/tekle/oss');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/src/com/tekle/oss/android');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/src/com/tekle/oss/android/animation');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/animation?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/src/com/tekle/oss/android/animation/FlipAnimation.java');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/animation/FlipAnimation.java?r\x3d2\x26spec\x3dsvn4');
 
 var selected_path = '/trunk/src/com/tekle/oss/android/animation/FlipAnimation.java';
 
 
 changed_paths.push('/trunk/src/com/tekle/oss/android/flipviewtransition');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/flipviewtransition?r\x3d2\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/src/com/tekle/oss/android/flipviewtransition/Flip3DViewTransitionActivity.java');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/flipviewtransition/Flip3DViewTransitionActivity.java?r\x3d2\x26spec\x3dsvn4');
 
 
 function getCurrentPageIndex() {
 for (var i = 0; i < changed_paths.length; i++) {
 if (selected_path == changed_paths[i]) {
 return i;
 }
 }
 }
 function getNextPage() {
 var i = getCurrentPageIndex();
 if (i < changed_paths.length - 1) {
 return changed_urls[i + 1];
 }
 return null;
 }
 function getPreviousPage() {
 var i = getCurrentPageIndex();
 if (i > 0) {
 return changed_urls[i - 1];
 }
 return null;
 }
 function gotoNextPage() {
 var page = getNextPage();
 if (!page) {
 page = detail_url;
 }
 window.location = page;
 }
 function gotoPreviousPage() {
 var page = getPreviousPage();
 if (!page) {
 page = detail_url;
 }
 window.location = page;
 }
 function gotoDetailPage() {
 window.location = detail_url;
 }
 function gotoPublishPage() {
 window.location = publish_url;
 }
</script>

 
 <style type="text/css">
 #review_nav {
 border-top: 3px solid white;
 padding-top: 6px;
 margin-top: 1em;
 }
 #review_nav td {
 vertical-align: middle;
 }
 #review_nav select {
 margin: .5em 0;
 }
 </style>
 <div id="review_nav">
 <table><tr><td>Go to:&nbsp;</td><td>
 <select name="files_in_rev" onchange="window.location=this.value">
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/.classpath?r=2&amp;spec=svn4"
 
 >/trunk/.classpath</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/.project?r=2&amp;spec=svn4"
 
 >/trunk/.project</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/AndroidManifest.xml?r=2&amp;spec=svn4"
 
 >/trunk/AndroidManifest.xml</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/assets?r=2&amp;spec=svn4"
 
 >/trunk/assets</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/bin?r=2&amp;spec=svn4"
 
 >/trunk/bin</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/default.properties?r=2&amp;spec=svn4"
 
 >/trunk/default.properties</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/gen?r=2&amp;spec=svn4"
 
 >/trunk/gen</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/gen/com?r=2&amp;spec=svn4"
 
 >/trunk/gen/com</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/gen/com/tekle?r=2&amp;spec=svn4"
 
 >/trunk/gen/com/tekle</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/gen/com/tekle/oss?r=2&amp;spec=svn4"
 
 >/trunk/gen/com/tekle/oss</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/gen/com/tekle/oss/android?r=2&amp;spec=svn4"
 
 >/trunk/gen/com/tekle/oss/android</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/gen/com/tekle/oss/android/flipviewtransition?r=2&amp;spec=svn4"
 
 >...e/oss/android/flipviewtransition</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/gen/com/tekle/oss/android/flipviewtransition/R.java?r=2&amp;spec=svn4"
 
 >...ndroid/flipviewtransition/R.java</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/proguard.cfg?r=2&amp;spec=svn4"
 
 >/trunk/proguard.cfg</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res?r=2&amp;spec=svn4"
 
 >/trunk/res</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable?r=2&amp;spec=svn4"
 
 >/trunk/res/drawable</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable-hdpi?r=2&amp;spec=svn4"
 
 >/trunk/res/drawable-hdpi</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable-hdpi/icon.png?r=2&amp;spec=svn4"
 
 >/trunk/res/drawable-hdpi/icon.png</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable-ldpi?r=2&amp;spec=svn4"
 
 >/trunk/res/drawable-ldpi</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable-ldpi/icon.png?r=2&amp;spec=svn4"
 
 >/trunk/res/drawable-ldpi/icon.png</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable-mdpi?r=2&amp;spec=svn4"
 
 >/trunk/res/drawable-mdpi</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable-mdpi/icon.png?r=2&amp;spec=svn4"
 
 >/trunk/res/drawable-mdpi/icon.png</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable/grid.png?r=2&amp;spec=svn4"
 
 >/trunk/res/drawable/grid.png</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable/larrypage.png?r=2&amp;spec=svn4"
 
 >/trunk/res/drawable/larrypage.png</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/drawable/larrypage_bio.png?r=2&amp;spec=svn4"
 
 >...k/res/drawable/larrypage_bio.png</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/layout?r=2&amp;spec=svn4"
 
 >/trunk/res/layout</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/layout/main.xml?r=2&amp;spec=svn4"
 
 >/trunk/res/layout/main.xml</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/values?r=2&amp;spec=svn4"
 
 >/trunk/res/values</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/values/strings.xml?r=2&amp;spec=svn4"
 
 >/trunk/res/values/strings.xml</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/src?r=2&amp;spec=svn4"
 
 >/trunk/src</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/src/com?r=2&amp;spec=svn4"
 
 >/trunk/src/com</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle?r=2&amp;spec=svn4"
 
 >/trunk/src/com/tekle</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss?r=2&amp;spec=svn4"
 
 >/trunk/src/com/tekle/oss</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android?r=2&amp;spec=svn4"
 
 >/trunk/src/com/tekle/oss/android</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/animation?r=2&amp;spec=svn4"
 
 >.../com/tekle/oss/android/animation</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java?r=2&amp;spec=svn4"
 
 >.../animation/AnimationFactory.java</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/animation/FlipAnimation.java?r=2&amp;spec=svn4"
 selected="selected"
 >...oid/animation/FlipAnimation.java</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/flipviewtransition?r=2&amp;spec=svn4"
 
 >...e/oss/android/flipviewtransition</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/flipviewtransition/Flip3DViewTransitionActivity.java?r=2&amp;spec=svn4"
 
 >...lip3DViewTransitionActivity.java</option>
 
 </select>
 </td></tr></table>
 
 
 



 
 </div>
 
 
 </div>
 <div class="round1"></div>
 <div class="round2"></div>
 <div class="round4"></div>
 </div>
 <div class="pmeta_bubble_bg" style="border:1px solid white">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <div id="older_bubble">
 <p>Older revisions</p>
 
 <a href="/p/android-3d-flip-view-transition/source/list?path=/trunk/src/com/tekle/oss/android/animation/FlipAnimation.java&start=2">All revisions of this file</a>
 </div>
 </div>
 <div class="round1"></div>
 <div class="round2"></div>
 <div class="round4"></div>
 </div>
 
 <div class="pmeta_bubble_bg" style="border:1px solid white">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <div id="fileinfo_bubble">
 <p>File info</p>
 
 <div>Size: 5648 bytes,
 160 lines</div>
 
 <div><a href="//android-3d-flip-view-transition.googlecode.com/svn/trunk/src/com/tekle/oss/android/animation/FlipAnimation.java">View raw file</a></div>
 </div>
 
 <div id="props">
 <p>File properties</p>
 <dl>
 
 <dt>svn:mime-type</dt>
 <dd>text/plain</dd>
 
 </dl>
 </div>
 
 </div>
 <div class="round1"></div>
 <div class="round2"></div>
 <div class="round4"></div>
 </div>
 </div>
 </div>


</div>

</div>
</div>

<script src="https://ssl.gstatic.com/codesite/ph/8599073060794244502/js/prettify/prettify.js"></script>
<script type="text/javascript">prettyPrint();</script>


<script src="https://ssl.gstatic.com/codesite/ph/8599073060794244502/js/source_file_scripts.js"></script>

 <script type="text/javascript" src="https://ssl.gstatic.com/codesite/ph/8599073060794244502/js/kibbles.js"></script>
 <script type="text/javascript">
 var lastStop = null;
 var initialized = false;
 
 function updateCursor(next, prev) {
 if (prev && prev.element) {
 prev.element.className = 'cursor_stop cursor_hidden';
 }
 if (next && next.element) {
 next.element.className = 'cursor_stop cursor';
 lastStop = next.index;
 }
 }
 
 function pubRevealed(data) {
 updateCursorForCell(data.cellId, 'cursor_stop cursor_hidden');
 if (initialized) {
 reloadCursors();
 }
 }
 
 function draftRevealed(data) {
 updateCursorForCell(data.cellId, 'cursor_stop cursor_hidden');
 if (initialized) {
 reloadCursors();
 }
 }
 
 function draftDestroyed(data) {
 updateCursorForCell(data.cellId, 'nocursor');
 if (initialized) {
 reloadCursors();
 }
 }
 function reloadCursors() {
 kibbles.skipper.reset();
 loadCursors();
 if (lastStop != null) {
 kibbles.skipper.setCurrentStop(lastStop);
 }
 }
 // possibly the simplest way to insert any newly added comments
 // is to update the class of the corresponding cursor row,
 // then refresh the entire list of rows.
 function updateCursorForCell(cellId, className) {
 var cell = document.getElementById(cellId);
 // we have to go two rows back to find the cursor location
 var row = getPreviousElement(cell.parentNode);
 row.className = className;
 }
 // returns the previous element, ignores text nodes.
 function getPreviousElement(e) {
 var element = e.previousSibling;
 if (element.nodeType == 3) {
 element = element.previousSibling;
 }
 if (element && element.tagName) {
 return element;
 }
 }
 function loadCursors() {
 // register our elements with skipper
 var elements = CR_getElements('*', 'cursor_stop');
 var len = elements.length;
 for (var i = 0; i < len; i++) {
 var element = elements[i]; 
 element.className = 'cursor_stop cursor_hidden';
 kibbles.skipper.append(element);
 }
 }
 function toggleComments() {
 CR_toggleCommentDisplay();
 reloadCursors();
 }
 function keysOnLoadHandler() {
 // setup skipper
 kibbles.skipper.addStopListener(
 kibbles.skipper.LISTENER_TYPE.PRE, updateCursor);
 // Set the 'offset' option to return the middle of the client area
 // an option can be a static value, or a callback
 kibbles.skipper.setOption('padding_top', 50);
 // Set the 'offset' option to return the middle of the client area
 // an option can be a static value, or a callback
 kibbles.skipper.setOption('padding_bottom', 100);
 // Register our keys
 kibbles.skipper.addFwdKey("n");
 kibbles.skipper.addRevKey("p");
 kibbles.keys.addKeyPressListener(
 'u', function() { window.location = detail_url; });
 kibbles.keys.addKeyPressListener(
 'r', function() { window.location = detail_url + '#publish'; });
 
 kibbles.keys.addKeyPressListener('j', gotoNextPage);
 kibbles.keys.addKeyPressListener('k', gotoPreviousPage);
 
 
 }
 </script>
<script src="https://ssl.gstatic.com/codesite/ph/8599073060794244502/js/code_review_scripts.js"></script>
<script type="text/javascript">
 function showPublishInstructions() {
 var element = document.getElementById('review_instr');
 if (element) {
 element.className = 'opened';
 }
 }
 var codereviews;
 function revsOnLoadHandler() {
 // register our source container with the commenting code
 var paths = {'svn4': '/trunk/src/com/tekle/oss/android/animation/FlipAnimation.java'}
 codereviews = CR_controller.setup(
 {"domainName": null, "assetHostPath": "https://ssl.gstatic.com/codesite/ph", "relativeBaseUrl": "", "loggedInUserEmail": "potatothezero@gmail.com", "projectName": "android-3d-flip-view-transition", "projectHomeUrl": "/p/android-3d-flip-view-transition", "token": "ABZ6GAeV9_Zxb4N785Ocqv2SZ_lmHtxVDw:1434264997523", "profileUrl": "/u/107328840504307469604/", "assetVersionPath": "https://ssl.gstatic.com/codesite/ph/8599073060794244502"}, '', 'svn4', paths,
 CR_BrowseIntegrationFactory);
 
 codereviews.registerActivityListener(CR_ActivityType.REVEAL_DRAFT_PLATE, showPublishInstructions);
 
 codereviews.registerActivityListener(CR_ActivityType.REVEAL_PUB_PLATE, pubRevealed);
 codereviews.registerActivityListener(CR_ActivityType.REVEAL_DRAFT_PLATE, draftRevealed);
 codereviews.registerActivityListener(CR_ActivityType.DISCARD_DRAFT_COMMENT, draftDestroyed);
 
 
 
 
 
 
 
 var initialized = true;
 reloadCursors();
 }
 window.onload = function() {keysOnLoadHandler(); revsOnLoadHandler();};

</script>
<script type="text/javascript" src="https://ssl.gstatic.com/codesite/ph/8599073060794244502/js/dit_scripts.js"></script>

 
 
 
 <script type="text/javascript" src="https://ssl.gstatic.com/codesite/ph/8599073060794244502/js/ph_core.js"></script>
 
 
 
 
</div> 

<div id="footer" dir="ltr">
 <div class="text">
 <a href="/projecthosting/terms.html">Terms</a> -
 <a href="http://www.google.com/privacy.html">Privacy</a> -
 <a href="/p/support/">Project Hosting Help</a>
 </div>
</div>
 <div class="hostedBy" style="margin-top: -20px;">
 <span style="vertical-align: top;">Powered by <a href="http://code.google.com/projecthosting/">Google Project Hosting</a></span>
 </div>

 
 


 
 </body>
</html>

