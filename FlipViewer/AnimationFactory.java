



<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" >
 
 <meta name="ROBOTS" content="NOARCHIVE">
 
 <link rel="icon" type="image/vnd.microsoft.icon" href="https://ssl.gstatic.com/codesite/ph/images/phosting.ico">
 
 
 <script type="text/javascript">
 
 
 
 
 var codesite_token = "ABZ6GAebXUX0Y9OXMwWbdjoU8mAltkdmcg:1434264984218";
 
 
 var CS_env = {"loggedInUserEmail": "potatothezero@gmail.com", "relativeBaseUrl": "", "projectHomeUrl": "/p/android-3d-flip-view-transition", "projectName": "android-3d-flip-view-transition", "assetVersionPath": "https://ssl.gstatic.com/codesite/ph/8599073060794244502", "domainName": null, "assetHostPath": "https://ssl.gstatic.com/codesite/ph", "token": "ABZ6GAebXUX0Y9OXMwWbdjoU8mAltkdmcg:1434264984218", "profileUrl": "/u/107328840504307469604/"};
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
 
 
 <title>AnimationFactory.java - 
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
 | <a href="https://www.google.com/accounts/Logout?continue=https%3A%2F%2Fcode.google.com%2Fp%2Fandroid-3d-flip-view-transition%2Fsource%2Fbrowse%2Ftrunk%2Fsrc%2Fcom%2Ftekle%2Foss%2Fandroid%2Fanimation%2FAnimationFactory.java" 
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
 <span id="crumb_links" class="ifClosed"><a href="/p/android-3d-flip-view-transition/source/browse/trunk/">trunk</a><span class="sp">/&nbsp;</span><a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/">src</a><span class="sp">/&nbsp;</span><a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/">com</a><span class="sp">/&nbsp;</span><a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/">tekle</a><span class="sp">/&nbsp;</span><a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/">oss</a><span class="sp">/&nbsp;</span><a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/">android</a><span class="sp">/&nbsp;</span><a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/animation/">animation</a><span class="sp">/&nbsp;</span>AnimationFactory.java</span>
 
 


 </td>
 
 
 <td nowrap="nowrap" width="33%" align="center">
 <a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java?edit=1"
 ><img src="https://ssl.gstatic.com/codesite/ph/images/pencil-y14.png"
 class="edit_icon">Edit file</a>
 </td>
 
 
 <td nowrap="nowrap" width="33%" align="right">
 <table cellpadding="0" cellspacing="0" style="font-size: 100%"><tr>
 
 
 <td class="flipper">
 <ul class="leftside">
 
 <li><a href="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java?r=2" title="Previous">&lsaquo;r2</a></li>
 
 </ul>
 </td>
 
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
><tr id="gr_svn4_161"

><td id="161"><a href="#161">161</a></td></tr
><tr id="gr_svn4_162"

><td id="162"><a href="#162">162</a></td></tr
><tr id="gr_svn4_163"

><td id="163"><a href="#163">163</a></td></tr
><tr id="gr_svn4_164"

><td id="164"><a href="#164">164</a></td></tr
><tr id="gr_svn4_165"

><td id="165"><a href="#165">165</a></td></tr
><tr id="gr_svn4_166"

><td id="166"><a href="#166">166</a></td></tr
><tr id="gr_svn4_167"

><td id="167"><a href="#167">167</a></td></tr
><tr id="gr_svn4_168"

><td id="168"><a href="#168">168</a></td></tr
><tr id="gr_svn4_169"

><td id="169"><a href="#169">169</a></td></tr
><tr id="gr_svn4_170"

><td id="170"><a href="#170">170</a></td></tr
><tr id="gr_svn4_171"

><td id="171"><a href="#171">171</a></td></tr
><tr id="gr_svn4_172"

><td id="172"><a href="#172">172</a></td></tr
><tr id="gr_svn4_173"

><td id="173"><a href="#173">173</a></td></tr
><tr id="gr_svn4_174"

><td id="174"><a href="#174">174</a></td></tr
><tr id="gr_svn4_175"

><td id="175"><a href="#175">175</a></td></tr
><tr id="gr_svn4_176"

><td id="176"><a href="#176">176</a></td></tr
><tr id="gr_svn4_177"

><td id="177"><a href="#177">177</a></td></tr
><tr id="gr_svn4_178"

><td id="178"><a href="#178">178</a></td></tr
><tr id="gr_svn4_179"

><td id="179"><a href="#179">179</a></td></tr
><tr id="gr_svn4_180"

><td id="180"><a href="#180">180</a></td></tr
><tr id="gr_svn4_181"

><td id="181"><a href="#181">181</a></td></tr
><tr id="gr_svn4_182"

><td id="182"><a href="#182">182</a></td></tr
><tr id="gr_svn4_183"

><td id="183"><a href="#183">183</a></td></tr
><tr id="gr_svn4_184"

><td id="184"><a href="#184">184</a></td></tr
><tr id="gr_svn4_185"

><td id="185"><a href="#185">185</a></td></tr
><tr id="gr_svn4_186"

><td id="186"><a href="#186">186</a></td></tr
><tr id="gr_svn4_187"

><td id="187"><a href="#187">187</a></td></tr
><tr id="gr_svn4_188"

><td id="188"><a href="#188">188</a></td></tr
><tr id="gr_svn4_189"

><td id="189"><a href="#189">189</a></td></tr
><tr id="gr_svn4_190"

><td id="190"><a href="#190">190</a></td></tr
><tr id="gr_svn4_191"

><td id="191"><a href="#191">191</a></td></tr
><tr id="gr_svn4_192"

><td id="192"><a href="#192">192</a></td></tr
><tr id="gr_svn4_193"

><td id="193"><a href="#193">193</a></td></tr
><tr id="gr_svn4_194"

><td id="194"><a href="#194">194</a></td></tr
><tr id="gr_svn4_195"

><td id="195"><a href="#195">195</a></td></tr
><tr id="gr_svn4_196"

><td id="196"><a href="#196">196</a></td></tr
><tr id="gr_svn4_197"

><td id="197"><a href="#197">197</a></td></tr
><tr id="gr_svn4_198"

><td id="198"><a href="#198">198</a></td></tr
><tr id="gr_svn4_199"

><td id="199"><a href="#199">199</a></td></tr
><tr id="gr_svn4_200"

><td id="200"><a href="#200">200</a></td></tr
><tr id="gr_svn4_201"

><td id="201"><a href="#201">201</a></td></tr
><tr id="gr_svn4_202"

><td id="202"><a href="#202">202</a></td></tr
><tr id="gr_svn4_203"

><td id="203"><a href="#203">203</a></td></tr
><tr id="gr_svn4_204"

><td id="204"><a href="#204">204</a></td></tr
><tr id="gr_svn4_205"

><td id="205"><a href="#205">205</a></td></tr
><tr id="gr_svn4_206"

><td id="206"><a href="#206">206</a></td></tr
><tr id="gr_svn4_207"

><td id="207"><a href="#207">207</a></td></tr
><tr id="gr_svn4_208"

><td id="208"><a href="#208">208</a></td></tr
><tr id="gr_svn4_209"

><td id="209"><a href="#209">209</a></td></tr
><tr id="gr_svn4_210"

><td id="210"><a href="#210">210</a></td></tr
><tr id="gr_svn4_211"

><td id="211"><a href="#211">211</a></td></tr
><tr id="gr_svn4_212"

><td id="212"><a href="#212">212</a></td></tr
><tr id="gr_svn4_213"

><td id="213"><a href="#213">213</a></td></tr
><tr id="gr_svn4_214"

><td id="214"><a href="#214">214</a></td></tr
><tr id="gr_svn4_215"

><td id="215"><a href="#215">215</a></td></tr
><tr id="gr_svn4_216"

><td id="216"><a href="#216">216</a></td></tr
><tr id="gr_svn4_217"

><td id="217"><a href="#217">217</a></td></tr
><tr id="gr_svn4_218"

><td id="218"><a href="#218">218</a></td></tr
><tr id="gr_svn4_219"

><td id="219"><a href="#219">219</a></td></tr
><tr id="gr_svn4_220"

><td id="220"><a href="#220">220</a></td></tr
><tr id="gr_svn4_221"

><td id="221"><a href="#221">221</a></td></tr
><tr id="gr_svn4_222"

><td id="222"><a href="#222">222</a></td></tr
><tr id="gr_svn4_223"

><td id="223"><a href="#223">223</a></td></tr
><tr id="gr_svn4_224"

><td id="224"><a href="#224">224</a></td></tr
><tr id="gr_svn4_225"

><td id="225"><a href="#225">225</a></td></tr
><tr id="gr_svn4_226"

><td id="226"><a href="#226">226</a></td></tr
><tr id="gr_svn4_227"

><td id="227"><a href="#227">227</a></td></tr
><tr id="gr_svn4_228"

><td id="228"><a href="#228">228</a></td></tr
><tr id="gr_svn4_229"

><td id="229"><a href="#229">229</a></td></tr
><tr id="gr_svn4_230"

><td id="230"><a href="#230">230</a></td></tr
><tr id="gr_svn4_231"

><td id="231"><a href="#231">231</a></td></tr
><tr id="gr_svn4_232"

><td id="232"><a href="#232">232</a></td></tr
><tr id="gr_svn4_233"

><td id="233"><a href="#233">233</a></td></tr
><tr id="gr_svn4_234"

><td id="234"><a href="#234">234</a></td></tr
><tr id="gr_svn4_235"

><td id="235"><a href="#235">235</a></td></tr
><tr id="gr_svn4_236"

><td id="236"><a href="#236">236</a></td></tr
><tr id="gr_svn4_237"

><td id="237"><a href="#237">237</a></td></tr
><tr id="gr_svn4_238"

><td id="238"><a href="#238">238</a></td></tr
><tr id="gr_svn4_239"

><td id="239"><a href="#239">239</a></td></tr
><tr id="gr_svn4_240"

><td id="240"><a href="#240">240</a></td></tr
><tr id="gr_svn4_241"

><td id="241"><a href="#241">241</a></td></tr
><tr id="gr_svn4_242"

><td id="242"><a href="#242">242</a></td></tr
><tr id="gr_svn4_243"

><td id="243"><a href="#243">243</a></td></tr
><tr id="gr_svn4_244"

><td id="244"><a href="#244">244</a></td></tr
><tr id="gr_svn4_245"

><td id="245"><a href="#245">245</a></td></tr
><tr id="gr_svn4_246"

><td id="246"><a href="#246">246</a></td></tr
><tr id="gr_svn4_247"

><td id="247"><a href="#247">247</a></td></tr
><tr id="gr_svn4_248"

><td id="248"><a href="#248">248</a></td></tr
><tr id="gr_svn4_249"

><td id="249"><a href="#249">249</a></td></tr
><tr id="gr_svn4_250"

><td id="250"><a href="#250">250</a></td></tr
><tr id="gr_svn4_251"

><td id="251"><a href="#251">251</a></td></tr
><tr id="gr_svn4_252"

><td id="252"><a href="#252">252</a></td></tr
><tr id="gr_svn4_253"

><td id="253"><a href="#253">253</a></td></tr
><tr id="gr_svn4_254"

><td id="254"><a href="#254">254</a></td></tr
><tr id="gr_svn4_255"

><td id="255"><a href="#255">255</a></td></tr
><tr id="gr_svn4_256"

><td id="256"><a href="#256">256</a></td></tr
><tr id="gr_svn4_257"

><td id="257"><a href="#257">257</a></td></tr
><tr id="gr_svn4_258"

><td id="258"><a href="#258">258</a></td></tr
><tr id="gr_svn4_259"

><td id="259"><a href="#259">259</a></td></tr
><tr id="gr_svn4_260"

><td id="260"><a href="#260">260</a></td></tr
><tr id="gr_svn4_261"

><td id="261"><a href="#261">261</a></td></tr
><tr id="gr_svn4_262"

><td id="262"><a href="#262">262</a></td></tr
><tr id="gr_svn4_263"

><td id="263"><a href="#263">263</a></td></tr
><tr id="gr_svn4_264"

><td id="264"><a href="#264">264</a></td></tr
><tr id="gr_svn4_265"

><td id="265"><a href="#265">265</a></td></tr
><tr id="gr_svn4_266"

><td id="266"><a href="#266">266</a></td></tr
><tr id="gr_svn4_267"

><td id="267"><a href="#267">267</a></td></tr
><tr id="gr_svn4_268"

><td id="268"><a href="#268">268</a></td></tr
><tr id="gr_svn4_269"

><td id="269"><a href="#269">269</a></td></tr
><tr id="gr_svn4_270"

><td id="270"><a href="#270">270</a></td></tr
><tr id="gr_svn4_271"

><td id="271"><a href="#271">271</a></td></tr
><tr id="gr_svn4_272"

><td id="272"><a href="#272">272</a></td></tr
><tr id="gr_svn4_273"

><td id="273"><a href="#273">273</a></td></tr
><tr id="gr_svn4_274"

><td id="274"><a href="#274">274</a></td></tr
><tr id="gr_svn4_275"

><td id="275"><a href="#275">275</a></td></tr
><tr id="gr_svn4_276"

><td id="276"><a href="#276">276</a></td></tr
><tr id="gr_svn4_277"

><td id="277"><a href="#277">277</a></td></tr
><tr id="gr_svn4_278"

><td id="278"><a href="#278">278</a></td></tr
><tr id="gr_svn4_279"

><td id="279"><a href="#279">279</a></td></tr
><tr id="gr_svn4_280"

><td id="280"><a href="#280">280</a></td></tr
><tr id="gr_svn4_281"

><td id="281"><a href="#281">281</a></td></tr
><tr id="gr_svn4_282"

><td id="282"><a href="#282">282</a></td></tr
><tr id="gr_svn4_283"

><td id="283"><a href="#283">283</a></td></tr
><tr id="gr_svn4_284"

><td id="284"><a href="#284">284</a></td></tr
><tr id="gr_svn4_285"

><td id="285"><a href="#285">285</a></td></tr
><tr id="gr_svn4_286"

><td id="286"><a href="#286">286</a></td></tr
><tr id="gr_svn4_287"

><td id="287"><a href="#287">287</a></td></tr
><tr id="gr_svn4_288"

><td id="288"><a href="#288">288</a></td></tr
><tr id="gr_svn4_289"

><td id="289"><a href="#289">289</a></td></tr
><tr id="gr_svn4_290"

><td id="290"><a href="#290">290</a></td></tr
><tr id="gr_svn4_291"

><td id="291"><a href="#291">291</a></td></tr
><tr id="gr_svn4_292"

><td id="292"><a href="#292">292</a></td></tr
><tr id="gr_svn4_293"

><td id="293"><a href="#293">293</a></td></tr
><tr id="gr_svn4_294"

><td id="294"><a href="#294">294</a></td></tr
><tr id="gr_svn4_295"

><td id="295"><a href="#295">295</a></td></tr
><tr id="gr_svn4_296"

><td id="296"><a href="#296">296</a></td></tr
><tr id="gr_svn4_297"

><td id="297"><a href="#297">297</a></td></tr
><tr id="gr_svn4_298"

><td id="298"><a href="#298">298</a></td></tr
><tr id="gr_svn4_299"

><td id="299"><a href="#299">299</a></td></tr
><tr id="gr_svn4_300"

><td id="300"><a href="#300">300</a></td></tr
><tr id="gr_svn4_301"

><td id="301"><a href="#301">301</a></td></tr
><tr id="gr_svn4_302"

><td id="302"><a href="#302">302</a></td></tr
><tr id="gr_svn4_303"

><td id="303"><a href="#303">303</a></td></tr
><tr id="gr_svn4_304"

><td id="304"><a href="#304">304</a></td></tr
><tr id="gr_svn4_305"

><td id="305"><a href="#305">305</a></td></tr
><tr id="gr_svn4_306"

><td id="306"><a href="#306">306</a></td></tr
><tr id="gr_svn4_307"

><td id="307"><a href="#307">307</a></td></tr
><tr id="gr_svn4_308"

><td id="308"><a href="#308">308</a></td></tr
><tr id="gr_svn4_309"

><td id="309"><a href="#309">309</a></td></tr
><tr id="gr_svn4_310"

><td id="310"><a href="#310">310</a></td></tr
><tr id="gr_svn4_311"

><td id="311"><a href="#311">311</a></td></tr
><tr id="gr_svn4_312"

><td id="312"><a href="#312">312</a></td></tr
><tr id="gr_svn4_313"

><td id="313"><a href="#313">313</a></td></tr
><tr id="gr_svn4_314"

><td id="314"><a href="#314">314</a></td></tr
><tr id="gr_svn4_315"

><td id="315"><a href="#315">315</a></td></tr
><tr id="gr_svn4_316"

><td id="316"><a href="#316">316</a></td></tr
><tr id="gr_svn4_317"

><td id="317"><a href="#317">317</a></td></tr
><tr id="gr_svn4_318"

><td id="318"><a href="#318">318</a></td></tr
><tr id="gr_svn4_319"

><td id="319"><a href="#319">319</a></td></tr
><tr id="gr_svn4_320"

><td id="320"><a href="#320">320</a></td></tr
><tr id="gr_svn4_321"

><td id="321"><a href="#321">321</a></td></tr
><tr id="gr_svn4_322"

><td id="322"><a href="#322">322</a></td></tr
><tr id="gr_svn4_323"

><td id="323"><a href="#323">323</a></td></tr
><tr id="gr_svn4_324"

><td id="324"><a href="#324">324</a></td></tr
><tr id="gr_svn4_325"

><td id="325"><a href="#325">325</a></td></tr
><tr id="gr_svn4_326"

><td id="326"><a href="#326">326</a></td></tr
><tr id="gr_svn4_327"

><td id="327"><a href="#327">327</a></td></tr
><tr id="gr_svn4_328"

><td id="328"><a href="#328">328</a></td></tr
><tr id="gr_svn4_329"

><td id="329"><a href="#329">329</a></td></tr
><tr id="gr_svn4_330"

><td id="330"><a href="#330">330</a></td></tr
><tr id="gr_svn4_331"

><td id="331"><a href="#331">331</a></td></tr
><tr id="gr_svn4_332"

><td id="332"><a href="#332">332</a></td></tr
><tr id="gr_svn4_333"

><td id="333"><a href="#333">333</a></td></tr
><tr id="gr_svn4_334"

><td id="334"><a href="#334">334</a></td></tr
><tr id="gr_svn4_335"

><td id="335"><a href="#335">335</a></td></tr
><tr id="gr_svn4_336"

><td id="336"><a href="#336">336</a></td></tr
><tr id="gr_svn4_337"

><td id="337"><a href="#337">337</a></td></tr
><tr id="gr_svn4_338"

><td id="338"><a href="#338">338</a></td></tr
><tr id="gr_svn4_339"

><td id="339"><a href="#339">339</a></td></tr
><tr id="gr_svn4_340"

><td id="340"><a href="#340">340</a></td></tr
><tr id="gr_svn4_341"

><td id="341"><a href="#341">341</a></td></tr
><tr id="gr_svn4_342"

><td id="342"><a href="#342">342</a></td></tr
><tr id="gr_svn4_343"

><td id="343"><a href="#343">343</a></td></tr
><tr id="gr_svn4_344"

><td id="344"><a href="#344">344</a></td></tr
><tr id="gr_svn4_345"

><td id="345"><a href="#345">345</a></td></tr
><tr id="gr_svn4_346"

><td id="346"><a href="#346">346</a></td></tr
><tr id="gr_svn4_347"

><td id="347"><a href="#347">347</a></td></tr
><tr id="gr_svn4_348"

><td id="348"><a href="#348">348</a></td></tr
><tr id="gr_svn4_349"

><td id="349"><a href="#349">349</a></td></tr
><tr id="gr_svn4_350"

><td id="350"><a href="#350">350</a></td></tr
><tr id="gr_svn4_351"

><td id="351"><a href="#351">351</a></td></tr
><tr id="gr_svn4_352"

><td id="352"><a href="#352">352</a></td></tr
><tr id="gr_svn4_353"

><td id="353"><a href="#353">353</a></td></tr
><tr id="gr_svn4_354"

><td id="354"><a href="#354">354</a></td></tr
><tr id="gr_svn4_355"

><td id="355"><a href="#355">355</a></td></tr
><tr id="gr_svn4_356"

><td id="356"><a href="#356">356</a></td></tr
><tr id="gr_svn4_357"

><td id="357"><a href="#357">357</a></td></tr
><tr id="gr_svn4_358"

><td id="358"><a href="#358">358</a></td></tr
><tr id="gr_svn4_359"

><td id="359"><a href="#359">359</a></td></tr
><tr id="gr_svn4_360"

><td id="360"><a href="#360">360</a></td></tr
><tr id="gr_svn4_361"

><td id="361"><a href="#361">361</a></td></tr
><tr id="gr_svn4_362"

><td id="362"><a href="#362">362</a></td></tr
><tr id="gr_svn4_363"

><td id="363"><a href="#363">363</a></td></tr
><tr id="gr_svn4_364"

><td id="364"><a href="#364">364</a></td></tr
><tr id="gr_svn4_365"

><td id="365"><a href="#365">365</a></td></tr
><tr id="gr_svn4_366"

><td id="366"><a href="#366">366</a></td></tr
><tr id="gr_svn4_367"

><td id="367"><a href="#367">367</a></td></tr
><tr id="gr_svn4_368"

><td id="368"><a href="#368">368</a></td></tr
><tr id="gr_svn4_369"

><td id="369"><a href="#369">369</a></td></tr
><tr id="gr_svn4_370"

><td id="370"><a href="#370">370</a></td></tr
><tr id="gr_svn4_371"

><td id="371"><a href="#371">371</a></td></tr
><tr id="gr_svn4_372"

><td id="372"><a href="#372">372</a></td></tr
><tr id="gr_svn4_373"

><td id="373"><a href="#373">373</a></td></tr
><tr id="gr_svn4_374"

><td id="374"><a href="#374">374</a></td></tr
><tr id="gr_svn4_375"

><td id="375"><a href="#375">375</a></td></tr
><tr id="gr_svn4_376"

><td id="376"><a href="#376">376</a></td></tr
><tr id="gr_svn4_377"

><td id="377"><a href="#377">377</a></td></tr
><tr id="gr_svn4_378"

><td id="378"><a href="#378">378</a></td></tr
><tr id="gr_svn4_379"

><td id="379"><a href="#379">379</a></td></tr
><tr id="gr_svn4_380"

><td id="380"><a href="#380">380</a></td></tr
><tr id="gr_svn4_381"

><td id="381"><a href="#381">381</a></td></tr
><tr id="gr_svn4_382"

><td id="382"><a href="#382">382</a></td></tr
><tr id="gr_svn4_383"

><td id="383"><a href="#383">383</a></td></tr
><tr id="gr_svn4_384"

><td id="384"><a href="#384">384</a></td></tr
><tr id="gr_svn4_385"

><td id="385"><a href="#385">385</a></td></tr
><tr id="gr_svn4_386"

><td id="386"><a href="#386">386</a></td></tr
><tr id="gr_svn4_387"

><td id="387"><a href="#387">387</a></td></tr
><tr id="gr_svn4_388"

><td id="388"><a href="#388">388</a></td></tr
><tr id="gr_svn4_389"

><td id="389"><a href="#389">389</a></td></tr
><tr id="gr_svn4_390"

><td id="390"><a href="#390">390</a></td></tr
><tr id="gr_svn4_391"

><td id="391"><a href="#391">391</a></td></tr
><tr id="gr_svn4_392"

><td id="392"><a href="#392">392</a></td></tr
><tr id="gr_svn4_393"

><td id="393"><a href="#393">393</a></td></tr
><tr id="gr_svn4_394"

><td id="394"><a href="#394">394</a></td></tr
><tr id="gr_svn4_395"

><td id="395"><a href="#395">395</a></td></tr
><tr id="gr_svn4_396"

><td id="396"><a href="#396">396</a></td></tr
><tr id="gr_svn4_397"

><td id="397"><a href="#397">397</a></td></tr
><tr id="gr_svn4_398"

><td id="398"><a href="#398">398</a></td></tr
><tr id="gr_svn4_399"

><td id="399"><a href="#399">399</a></td></tr
><tr id="gr_svn4_400"

><td id="400"><a href="#400">400</a></td></tr
><tr id="gr_svn4_401"

><td id="401"><a href="#401">401</a></td></tr
><tr id="gr_svn4_402"

><td id="402"><a href="#402">402</a></td></tr
><tr id="gr_svn4_403"

><td id="403"><a href="#403">403</a></td></tr
><tr id="gr_svn4_404"

><td id="404"><a href="#404">404</a></td></tr
><tr id="gr_svn4_405"

><td id="405"><a href="#405">405</a></td></tr
><tr id="gr_svn4_406"

><td id="406"><a href="#406">406</a></td></tr
><tr id="gr_svn4_407"

><td id="407"><a href="#407">407</a></td></tr
><tr id="gr_svn4_408"

><td id="408"><a href="#408">408</a></td></tr
><tr id="gr_svn4_409"

><td id="409"><a href="#409">409</a></td></tr
><tr id="gr_svn4_410"

><td id="410"><a href="#410">410</a></td></tr
><tr id="gr_svn4_411"

><td id="411"><a href="#411">411</a></td></tr
><tr id="gr_svn4_412"

><td id="412"><a href="#412">412</a></td></tr
><tr id="gr_svn4_413"

><td id="413"><a href="#413">413</a></td></tr
><tr id="gr_svn4_414"

><td id="414"><a href="#414">414</a></td></tr
><tr id="gr_svn4_415"

><td id="415"><a href="#415">415</a></td></tr
><tr id="gr_svn4_416"

><td id="416"><a href="#416">416</a></td></tr
><tr id="gr_svn4_417"

><td id="417"><a href="#417">417</a></td></tr
><tr id="gr_svn4_418"

><td id="418"><a href="#418">418</a></td></tr
><tr id="gr_svn4_419"

><td id="419"><a href="#419">419</a></td></tr
><tr id="gr_svn4_420"

><td id="420"><a href="#420">420</a></td></tr
><tr id="gr_svn4_421"

><td id="421"><a href="#421">421</a></td></tr
><tr id="gr_svn4_422"

><td id="422"><a href="#422">422</a></td></tr
><tr id="gr_svn4_423"

><td id="423"><a href="#423">423</a></td></tr
><tr id="gr_svn4_424"

><td id="424"><a href="#424">424</a></td></tr
><tr id="gr_svn4_425"

><td id="425"><a href="#425">425</a></td></tr
><tr id="gr_svn4_426"

><td id="426"><a href="#426">426</a></td></tr
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

><td class="source">package com.tekle.oss.android.animation;  <br></td></tr
><tr
id=sl_svn4_23

><td class="source"><br></td></tr
><tr
id=sl_svn4_24

><td class="source">import android.view.View;<br></td></tr
><tr
id=sl_svn4_25

><td class="source">import android.view.animation.AccelerateInterpolator;<br></td></tr
><tr
id=sl_svn4_26

><td class="source">import android.view.animation.AlphaAnimation;<br></td></tr
><tr
id=sl_svn4_27

><td class="source">import android.view.animation.Animation;<br></td></tr
><tr
id=sl_svn4_28

><td class="source">import android.view.animation.AnimationSet;<br></td></tr
><tr
id=sl_svn4_29

><td class="source">import android.view.animation.DecelerateInterpolator;<br></td></tr
><tr
id=sl_svn4_30

><td class="source">import android.view.animation.Interpolator;<br></td></tr
><tr
id=sl_svn4_31

><td class="source">import android.view.animation.TranslateAnimation;<br></td></tr
><tr
id=sl_svn4_32

><td class="source">import android.view.animation.Animation.AnimationListener;<br></td></tr
><tr
id=sl_svn4_33

><td class="source">import android.widget.ViewAnimator;<br></td></tr
><tr
id=sl_svn4_34

><td class="source"><br></td></tr
><tr
id=sl_svn4_35

><td class="source">/**<br></td></tr
><tr
id=sl_svn4_36

><td class="source"> * This class contains methods for creating {@link Animation} objects for some of the most common animation, including a 3D flip animation, {@link FlipAnimation}.<br></td></tr
><tr
id=sl_svn4_37

><td class="source"> * Furthermore, utility methods are provided for initiating fade-in-then-out and flip animations.<br></td></tr
><tr
id=sl_svn4_38

><td class="source"> * <br></td></tr
><tr
id=sl_svn4_39

><td class="source"> * @author Ephraim A. Tekle<br></td></tr
><tr
id=sl_svn4_40

><td class="source"> *<br></td></tr
><tr
id=sl_svn4_41

><td class="source"> */<br></td></tr
><tr
id=sl_svn4_42

><td class="source">public class AnimationFactory {<br></td></tr
><tr
id=sl_svn4_43

><td class="source">	<br></td></tr
><tr
id=sl_svn4_44

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_45

><td class="source">	 * The {@code FlipDirection} enumeration defines the most typical flip view transitions: left-to-right and right-to-left. {@code FlipDirection} is used during the creation of {@link FlipAnimation} animations.<br></td></tr
><tr
id=sl_svn4_46

><td class="source">	 * <br></td></tr
><tr
id=sl_svn4_47

><td class="source">	 * @author Ephraim A. Tekle<br></td></tr
><tr
id=sl_svn4_48

><td class="source">	 *<br></td></tr
><tr
id=sl_svn4_49

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_50

><td class="source">	public static enum FlipDirection {<br></td></tr
><tr
id=sl_svn4_51

><td class="source">		LEFT_RIGHT, <br></td></tr
><tr
id=sl_svn4_52

><td class="source">		RIGHT_LEFT;<br></td></tr
><tr
id=sl_svn4_53

><td class="source">		<br></td></tr
><tr
id=sl_svn4_54

><td class="source">		public float getStartDegreeForFirstView() {<br></td></tr
><tr
id=sl_svn4_55

><td class="source">			return 0;<br></td></tr
><tr
id=sl_svn4_56

><td class="source">		}<br></td></tr
><tr
id=sl_svn4_57

><td class="source">		<br></td></tr
><tr
id=sl_svn4_58

><td class="source">		public float getStartDegreeForSecondView() {<br></td></tr
><tr
id=sl_svn4_59

><td class="source">			switch(this) {<br></td></tr
><tr
id=sl_svn4_60

><td class="source">			case LEFT_RIGHT:<br></td></tr
><tr
id=sl_svn4_61

><td class="source">				return -90;<br></td></tr
><tr
id=sl_svn4_62

><td class="source">			case RIGHT_LEFT:<br></td></tr
><tr
id=sl_svn4_63

><td class="source">				return 90;<br></td></tr
><tr
id=sl_svn4_64

><td class="source">			default:<br></td></tr
><tr
id=sl_svn4_65

><td class="source">				return 0;<br></td></tr
><tr
id=sl_svn4_66

><td class="source">			}<br></td></tr
><tr
id=sl_svn4_67

><td class="source">		}<br></td></tr
><tr
id=sl_svn4_68

><td class="source">		<br></td></tr
><tr
id=sl_svn4_69

><td class="source">		public float getEndDegreeForFirstView() {<br></td></tr
><tr
id=sl_svn4_70

><td class="source">			switch(this) {<br></td></tr
><tr
id=sl_svn4_71

><td class="source">			case LEFT_RIGHT:<br></td></tr
><tr
id=sl_svn4_72

><td class="source">				return 90;<br></td></tr
><tr
id=sl_svn4_73

><td class="source">			case RIGHT_LEFT:<br></td></tr
><tr
id=sl_svn4_74

><td class="source">				return -90;<br></td></tr
><tr
id=sl_svn4_75

><td class="source">			default:<br></td></tr
><tr
id=sl_svn4_76

><td class="source">				return 0;<br></td></tr
><tr
id=sl_svn4_77

><td class="source">			}<br></td></tr
><tr
id=sl_svn4_78

><td class="source">		}<br></td></tr
><tr
id=sl_svn4_79

><td class="source">		<br></td></tr
><tr
id=sl_svn4_80

><td class="source">		public float getEndDegreeForSecondView() {<br></td></tr
><tr
id=sl_svn4_81

><td class="source">			return 0;<br></td></tr
><tr
id=sl_svn4_82

><td class="source">		}<br></td></tr
><tr
id=sl_svn4_83

><td class="source">		<br></td></tr
><tr
id=sl_svn4_84

><td class="source">		public FlipDirection theOtherDirection() {<br></td></tr
><tr
id=sl_svn4_85

><td class="source">			switch(this) {<br></td></tr
><tr
id=sl_svn4_86

><td class="source">			case LEFT_RIGHT:<br></td></tr
><tr
id=sl_svn4_87

><td class="source">				return RIGHT_LEFT;<br></td></tr
><tr
id=sl_svn4_88

><td class="source">			case RIGHT_LEFT:<br></td></tr
><tr
id=sl_svn4_89

><td class="source">				return LEFT_RIGHT;<br></td></tr
><tr
id=sl_svn4_90

><td class="source">			default:<br></td></tr
><tr
id=sl_svn4_91

><td class="source">				return null;<br></td></tr
><tr
id=sl_svn4_92

><td class="source">			}<br></td></tr
><tr
id=sl_svn4_93

><td class="source">		}<br></td></tr
><tr
id=sl_svn4_94

><td class="source">	};<br></td></tr
><tr
id=sl_svn4_95

><td class="source">	 <br></td></tr
><tr
id=sl_svn4_96

><td class="source">	<br></td></tr
><tr
id=sl_svn4_97

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_98

><td class="source">	 * Create a pair of {@link FlipAnimation} that can be used to flip 3D transition from {@code fromView} to {@code toView}. A typical use case is with {@link ViewAnimator} as an out and in transition.<br></td></tr
><tr
id=sl_svn4_99

><td class="source">	 * <br></td></tr
><tr
id=sl_svn4_100

><td class="source">	 * NOTE: Avoid using this method. Instead, use {@link #flipTransition}.<br></td></tr
><tr
id=sl_svn4_101

><td class="source">	 *  <br></td></tr
><tr
id=sl_svn4_102

><td class="source">	 * @param fromView the view transition away from<br></td></tr
><tr
id=sl_svn4_103

><td class="source">	 * @param toView the view transition to<br></td></tr
><tr
id=sl_svn4_104

><td class="source">	 * @param dir the flip direction<br></td></tr
><tr
id=sl_svn4_105

><td class="source">	 * @param duration the transition duration in milliseconds<br></td></tr
><tr
id=sl_svn4_106

><td class="source">	 * @param interpolator the interpolator to use (pass {@code null} to use the {@link AccelerateInterpolator} interpolator) <br></td></tr
><tr
id=sl_svn4_107

><td class="source">	 * @return<br></td></tr
><tr
id=sl_svn4_108

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_109

><td class="source">	public static Animation[] flipAnimation(final View fromView, final View toView, FlipDirection dir, long duration, Interpolator interpolator) {<br></td></tr
><tr
id=sl_svn4_110

><td class="source">		Animation[] result = new Animation[2];<br></td></tr
><tr
id=sl_svn4_111

><td class="source">		float centerX;<br></td></tr
><tr
id=sl_svn4_112

><td class="source">		float centerY;<br></td></tr
><tr
id=sl_svn4_113

><td class="source">		<br></td></tr
><tr
id=sl_svn4_114

><td class="source">		centerX = fromView.getWidth() / 2.0f;<br></td></tr
><tr
id=sl_svn4_115

><td class="source">		centerY = fromView.getHeight() / 2.0f; <br></td></tr
><tr
id=sl_svn4_116

><td class="source">		<br></td></tr
><tr
id=sl_svn4_117

><td class="source">		Animation outFlip= new FlipAnimation(dir.getStartDegreeForFirstView(), dir.getEndDegreeForFirstView(), centerX, centerY, FlipAnimation.SCALE_DEFAULT, FlipAnimation.ScaleUpDownEnum.SCALE_DOWN);<br></td></tr
><tr
id=sl_svn4_118

><td class="source">		outFlip.setDuration(duration);<br></td></tr
><tr
id=sl_svn4_119

><td class="source">		outFlip.setFillAfter(true);<br></td></tr
><tr
id=sl_svn4_120

><td class="source">		outFlip.setInterpolator(interpolator==null?new AccelerateInterpolator():interpolator); <br></td></tr
><tr
id=sl_svn4_121

><td class="source"><br></td></tr
><tr
id=sl_svn4_122

><td class="source">		AnimationSet outAnimation = new AnimationSet(true);<br></td></tr
><tr
id=sl_svn4_123

><td class="source">		outAnimation.addAnimation(outFlip); <br></td></tr
><tr
id=sl_svn4_124

><td class="source">		result[0] = outAnimation; <br></td></tr
><tr
id=sl_svn4_125

><td class="source">		<br></td></tr
><tr
id=sl_svn4_126

><td class="source">		// Uncomment the following if toView has its layout established (not the case if using ViewFlipper and on first show)<br></td></tr
><tr
id=sl_svn4_127

><td class="source">		//centerX = toView.getWidth() / 2.0f;<br></td></tr
><tr
id=sl_svn4_128

><td class="source">		//centerY = toView.getHeight() / 2.0f; <br></td></tr
><tr
id=sl_svn4_129

><td class="source">		<br></td></tr
><tr
id=sl_svn4_130

><td class="source">		Animation inFlip = new FlipAnimation(dir.getStartDegreeForSecondView(), dir.getEndDegreeForSecondView(), centerX, centerY, FlipAnimation.SCALE_DEFAULT, FlipAnimation.ScaleUpDownEnum.SCALE_UP);<br></td></tr
><tr
id=sl_svn4_131

><td class="source">		inFlip.setDuration(duration);<br></td></tr
><tr
id=sl_svn4_132

><td class="source">		inFlip.setFillAfter(true);<br></td></tr
><tr
id=sl_svn4_133

><td class="source">		inFlip.setInterpolator(interpolator==null?new AccelerateInterpolator():interpolator);<br></td></tr
><tr
id=sl_svn4_134

><td class="source">		inFlip.setStartOffset(duration);   <br></td></tr
><tr
id=sl_svn4_135

><td class="source">		<br></td></tr
><tr
id=sl_svn4_136

><td class="source">		AnimationSet inAnimation = new AnimationSet(true); <br></td></tr
><tr
id=sl_svn4_137

><td class="source">		inAnimation.addAnimation(inFlip); <br></td></tr
><tr
id=sl_svn4_138

><td class="source">		result[1] = inAnimation; <br></td></tr
><tr
id=sl_svn4_139

><td class="source">		<br></td></tr
><tr
id=sl_svn4_140

><td class="source">		return result;<br></td></tr
><tr
id=sl_svn4_141

><td class="source">		<br></td></tr
><tr
id=sl_svn4_142

><td class="source">	}<br></td></tr
><tr
id=sl_svn4_143

><td class="source">	<br></td></tr
><tr
id=sl_svn4_144

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_145

><td class="source">	 * Flip to the next view of the {@code ViewAnimator}&#39;s subviews. A call to this method will initiate a {@link FlipAnimation} to show the next View.  <br></td></tr
><tr
id=sl_svn4_146

><td class="source">	 * If the currently visible view is the last view, flip direction will be reversed for this transition.<br></td></tr
><tr
id=sl_svn4_147

><td class="source">	 *  <br></td></tr
><tr
id=sl_svn4_148

><td class="source">	 * @param viewAnimator the {@code ViewAnimator}<br></td></tr
><tr
id=sl_svn4_149

><td class="source">	 * @param dir the direction of flip<br></td></tr
><tr
id=sl_svn4_150

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_151

><td class="source">	public static void flipTransition(final ViewAnimator viewAnimator, FlipDirection dir) {   <br></td></tr
><tr
id=sl_svn4_152

><td class="source">		<br></td></tr
><tr
id=sl_svn4_153

><td class="source">		final View fromView = viewAnimator.getCurrentView();<br></td></tr
><tr
id=sl_svn4_154

><td class="source">		final int currentIndex = viewAnimator.getDisplayedChild();<br></td></tr
><tr
id=sl_svn4_155

><td class="source">		final int nextIndex = (currentIndex + 1)%viewAnimator.getChildCount();<br></td></tr
><tr
id=sl_svn4_156

><td class="source">		<br></td></tr
><tr
id=sl_svn4_157

><td class="source">		final View toView = viewAnimator.getChildAt(nextIndex);<br></td></tr
><tr
id=sl_svn4_158

><td class="source"><br></td></tr
><tr
id=sl_svn4_159

><td class="source">		Animation[] animc = AnimationFactory.flipAnimation(fromView, toView, (nextIndex &lt; currentIndex?dir.theOtherDirection():dir), 500, null);<br></td></tr
><tr
id=sl_svn4_160

><td class="source">  <br></td></tr
><tr
id=sl_svn4_161

><td class="source">		viewAnimator.setOutAnimation(animc[0]);<br></td></tr
><tr
id=sl_svn4_162

><td class="source">		viewAnimator.setInAnimation(animc[1]);<br></td></tr
><tr
id=sl_svn4_163

><td class="source">		<br></td></tr
><tr
id=sl_svn4_164

><td class="source">		viewAnimator.showNext();   <br></td></tr
><tr
id=sl_svn4_165

><td class="source">	}<br></td></tr
><tr
id=sl_svn4_166

><td class="source">	<br></td></tr
><tr
id=sl_svn4_167

><td class="source">	//////////////<br></td></tr
><tr
id=sl_svn4_168

><td class="source"><br></td></tr
><tr
id=sl_svn4_169

><td class="source"> <br></td></tr
><tr
id=sl_svn4_170

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_171

><td class="source">	 * Slide animations to enter a view from left.<br></td></tr
><tr
id=sl_svn4_172

><td class="source">	 * <br></td></tr
><tr
id=sl_svn4_173

><td class="source">	 * @param duration the animation duration in milliseconds<br></td></tr
><tr
id=sl_svn4_174

><td class="source">	 * @param interpolator the interpolator to use (pass {@code null} to use the {@link AccelerateInterpolator} interpolator) 	<br></td></tr
><tr
id=sl_svn4_175

><td class="source">	 * @return a slide transition animation<br></td></tr
><tr
id=sl_svn4_176

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_177

><td class="source">	public static Animation inFromLeftAnimation(long duration, Interpolator interpolator) {<br></td></tr
><tr
id=sl_svn4_178

><td class="source">		Animation inFromLeft = new TranslateAnimation(<br></td></tr
><tr
id=sl_svn4_179

><td class="source">				Animation.RELATIVE_TO_PARENT,  -1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,<br></td></tr
><tr
id=sl_svn4_180

><td class="source">				Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f<br></td></tr
><tr
id=sl_svn4_181

><td class="source">		);<br></td></tr
><tr
id=sl_svn4_182

><td class="source">		inFromLeft.setDuration(duration);<br></td></tr
><tr
id=sl_svn4_183

><td class="source">		inFromLeft.setInterpolator(interpolator==null?new AccelerateInterpolator():interpolator); //AccelerateInterpolator<br></td></tr
><tr
id=sl_svn4_184

><td class="source">		return inFromLeft;<br></td></tr
><tr
id=sl_svn4_185

><td class="source">	}<br></td></tr
><tr
id=sl_svn4_186

><td class="source"> <br></td></tr
><tr
id=sl_svn4_187

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_188

><td class="source">	 * Slide animations to hide a view by sliding it to the right<br></td></tr
><tr
id=sl_svn4_189

><td class="source">	 * <br></td></tr
><tr
id=sl_svn4_190

><td class="source">	 * @param duration the animation duration in milliseconds<br></td></tr
><tr
id=sl_svn4_191

><td class="source">	 * @param interpolator the interpolator to use (pass {@code null} to use the {@link AccelerateInterpolator} interpolator) 	<br></td></tr
><tr
id=sl_svn4_192

><td class="source">	 * @return a slide transition animation<br></td></tr
><tr
id=sl_svn4_193

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_194

><td class="source">	public static Animation outToRightAnimation(long duration, Interpolator interpolator) {<br></td></tr
><tr
id=sl_svn4_195

><td class="source">		Animation outtoRight = new TranslateAnimation(<br></td></tr
><tr
id=sl_svn4_196

><td class="source">				Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  +1.0f,<br></td></tr
><tr
id=sl_svn4_197

><td class="source">				Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f<br></td></tr
><tr
id=sl_svn4_198

><td class="source">		);<br></td></tr
><tr
id=sl_svn4_199

><td class="source">		outtoRight.setDuration(duration);<br></td></tr
><tr
id=sl_svn4_200

><td class="source">		outtoRight.setInterpolator(interpolator==null?new AccelerateInterpolator():interpolator);<br></td></tr
><tr
id=sl_svn4_201

><td class="source">		return outtoRight;<br></td></tr
><tr
id=sl_svn4_202

><td class="source">	}<br></td></tr
><tr
id=sl_svn4_203

><td class="source"> <br></td></tr
><tr
id=sl_svn4_204

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_205

><td class="source">	 * Slide animations to enter a view from right.<br></td></tr
><tr
id=sl_svn4_206

><td class="source">	 * <br></td></tr
><tr
id=sl_svn4_207

><td class="source">	 * @param duration the animation duration in milliseconds<br></td></tr
><tr
id=sl_svn4_208

><td class="source">	 * @param interpolator the interpolator to use (pass {@code null} to use the {@link AccelerateInterpolator} interpolator) 	<br></td></tr
><tr
id=sl_svn4_209

><td class="source">	 * @return a slide transition animation<br></td></tr
><tr
id=sl_svn4_210

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_211

><td class="source">	public static Animation inFromRightAnimation(long duration, Interpolator interpolator) {<br></td></tr
><tr
id=sl_svn4_212

><td class="source"><br></td></tr
><tr
id=sl_svn4_213

><td class="source">		Animation inFromRight = new TranslateAnimation(<br></td></tr
><tr
id=sl_svn4_214

><td class="source">				Animation.RELATIVE_TO_PARENT,  +1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,<br></td></tr
><tr
id=sl_svn4_215

><td class="source">				Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f<br></td></tr
><tr
id=sl_svn4_216

><td class="source">		);<br></td></tr
><tr
id=sl_svn4_217

><td class="source">		inFromRight.setDuration(duration);<br></td></tr
><tr
id=sl_svn4_218

><td class="source">		inFromRight.setInterpolator(interpolator==null?new AccelerateInterpolator():interpolator);<br></td></tr
><tr
id=sl_svn4_219

><td class="source">		return inFromRight;<br></td></tr
><tr
id=sl_svn4_220

><td class="source">	}<br></td></tr
><tr
id=sl_svn4_221

><td class="source"> <br></td></tr
><tr
id=sl_svn4_222

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_223

><td class="source">	 * Slide animations to hide a view by sliding it to the left.<br></td></tr
><tr
id=sl_svn4_224

><td class="source">	 * <br></td></tr
><tr
id=sl_svn4_225

><td class="source">	 * @param duration the animation duration in milliseconds<br></td></tr
><tr
id=sl_svn4_226

><td class="source">	 * @param interpolator the interpolator to use (pass {@code null} to use the {@link AccelerateInterpolator} interpolator) 	<br></td></tr
><tr
id=sl_svn4_227

><td class="source">	 * @return a slide transition animation<br></td></tr
><tr
id=sl_svn4_228

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_229

><td class="source">	public static Animation outToLeftAnimation(long duration, Interpolator interpolator) {<br></td></tr
><tr
id=sl_svn4_230

><td class="source">		Animation outtoLeft = new TranslateAnimation(<br></td></tr
><tr
id=sl_svn4_231

><td class="source">				Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  -1.0f,<br></td></tr
><tr
id=sl_svn4_232

><td class="source">				Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f<br></td></tr
><tr
id=sl_svn4_233

><td class="source">		);<br></td></tr
><tr
id=sl_svn4_234

><td class="source">		outtoLeft.setDuration(duration);<br></td></tr
><tr
id=sl_svn4_235

><td class="source">		outtoLeft.setInterpolator(interpolator==null?new AccelerateInterpolator():interpolator);<br></td></tr
><tr
id=sl_svn4_236

><td class="source">		return outtoLeft;<br></td></tr
><tr
id=sl_svn4_237

><td class="source">	} <br></td></tr
><tr
id=sl_svn4_238

><td class="source"> <br></td></tr
><tr
id=sl_svn4_239

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_240

><td class="source">	 * Slide animations to enter a view from top.<br></td></tr
><tr
id=sl_svn4_241

><td class="source">	 * <br></td></tr
><tr
id=sl_svn4_242

><td class="source">	 * @param duration the animation duration in milliseconds<br></td></tr
><tr
id=sl_svn4_243

><td class="source">	 * @param interpolator the interpolator to use (pass {@code null} to use the {@link AccelerateInterpolator} interpolator) 	<br></td></tr
><tr
id=sl_svn4_244

><td class="source">	 * @return a slide transition animation<br></td></tr
><tr
id=sl_svn4_245

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_246

><td class="source">	public static Animation inFromTopAnimation(long duration, Interpolator interpolator) {<br></td></tr
><tr
id=sl_svn4_247

><td class="source">		Animation infromtop = new TranslateAnimation(<br></td></tr
><tr
id=sl_svn4_248

><td class="source">				Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT, 0.0f,<br></td></tr
><tr
id=sl_svn4_249

><td class="source">				Animation.RELATIVE_TO_PARENT, -1.0f, Animation.RELATIVE_TO_PARENT, 0.0f<br></td></tr
><tr
id=sl_svn4_250

><td class="source">		);<br></td></tr
><tr
id=sl_svn4_251

><td class="source">		infromtop.setDuration(duration);<br></td></tr
><tr
id=sl_svn4_252

><td class="source">		infromtop.setInterpolator(interpolator==null?new AccelerateInterpolator():interpolator);<br></td></tr
><tr
id=sl_svn4_253

><td class="source">		return infromtop;<br></td></tr
><tr
id=sl_svn4_254

><td class="source">	} <br></td></tr
><tr
id=sl_svn4_255

><td class="source"> <br></td></tr
><tr
id=sl_svn4_256

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_257

><td class="source">	 * Slide animations to hide a view by sliding it to the top<br></td></tr
><tr
id=sl_svn4_258

><td class="source">	 * <br></td></tr
><tr
id=sl_svn4_259

><td class="source">	 * @param duration the animation duration in milliseconds<br></td></tr
><tr
id=sl_svn4_260

><td class="source">	 * @param interpolator the interpolator to use (pass {@code null} to use the {@link AccelerateInterpolator} interpolator) 	<br></td></tr
><tr
id=sl_svn4_261

><td class="source">	 * @return a slide transition animation<br></td></tr
><tr
id=sl_svn4_262

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_263

><td class="source">	public static Animation outToTopAnimation(long duration, Interpolator interpolator) {<br></td></tr
><tr
id=sl_svn4_264

><td class="source">		Animation outtotop = new TranslateAnimation(<br></td></tr
><tr
id=sl_svn4_265

><td class="source">				Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  0.0f,<br></td></tr
><tr
id=sl_svn4_266

><td class="source">				Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT, -1.0f<br></td></tr
><tr
id=sl_svn4_267

><td class="source">		);<br></td></tr
><tr
id=sl_svn4_268

><td class="source">		outtotop.setDuration(duration); <br></td></tr
><tr
id=sl_svn4_269

><td class="source">		outtotop.setInterpolator(interpolator==null?new AccelerateInterpolator():interpolator); <br></td></tr
><tr
id=sl_svn4_270

><td class="source">		return outtotop;<br></td></tr
><tr
id=sl_svn4_271

><td class="source">	} <br></td></tr
><tr
id=sl_svn4_272

><td class="source"><br></td></tr
><tr
id=sl_svn4_273

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_274

><td class="source">	 * A fade animation that will fade the subject in by changing alpha from 0 to 1.<br></td></tr
><tr
id=sl_svn4_275

><td class="source">	 * <br></td></tr
><tr
id=sl_svn4_276

><td class="source">	 * @param duration the animation duration in milliseconds<br></td></tr
><tr
id=sl_svn4_277

><td class="source">	 * @param delay how long to wait before starting the animation, in milliseconds<br></td></tr
><tr
id=sl_svn4_278

><td class="source">	 * @return a fade animation<br></td></tr
><tr
id=sl_svn4_279

><td class="source">	 * @see #fadeInAnimation(View, long)<br></td></tr
><tr
id=sl_svn4_280

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_281

><td class="source">	public static Animation fadeInAnimation(long duration, long delay) {  <br></td></tr
><tr
id=sl_svn4_282

><td class="source">		<br></td></tr
><tr
id=sl_svn4_283

><td class="source">		Animation fadeIn = new AlphaAnimation(0, 1);<br></td></tr
><tr
id=sl_svn4_284

><td class="source">		fadeIn.setInterpolator(new DecelerateInterpolator());  <br></td></tr
><tr
id=sl_svn4_285

><td class="source">		fadeIn.setDuration(duration);<br></td></tr
><tr
id=sl_svn4_286

><td class="source">		fadeIn.setStartOffset(delay);<br></td></tr
><tr
id=sl_svn4_287

><td class="source">		<br></td></tr
><tr
id=sl_svn4_288

><td class="source">		return fadeIn;<br></td></tr
><tr
id=sl_svn4_289

><td class="source">	}<br></td></tr
><tr
id=sl_svn4_290

><td class="source"><br></td></tr
><tr
id=sl_svn4_291

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_292

><td class="source">	 * A fade animation that will fade the subject out by changing alpha from 1 to 0.<br></td></tr
><tr
id=sl_svn4_293

><td class="source">	 * <br></td></tr
><tr
id=sl_svn4_294

><td class="source">	 * @param duration the animation duration in milliseconds<br></td></tr
><tr
id=sl_svn4_295

><td class="source">	 * @param delay how long to wait before starting the animation, in milliseconds<br></td></tr
><tr
id=sl_svn4_296

><td class="source">	 * @return a fade animation<br></td></tr
><tr
id=sl_svn4_297

><td class="source">	 * @see #fadeOutAnimation(View, long)<br></td></tr
><tr
id=sl_svn4_298

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_299

><td class="source">	public static Animation fadeOutAnimation(long duration, long delay) {   <br></td></tr
><tr
id=sl_svn4_300

><td class="source"><br></td></tr
><tr
id=sl_svn4_301

><td class="source">		Animation fadeOut = new AlphaAnimation(1, 0);<br></td></tr
><tr
id=sl_svn4_302

><td class="source">		fadeOut.setInterpolator(new AccelerateInterpolator());<br></td></tr
><tr
id=sl_svn4_303

><td class="source">		fadeOut.setStartOffset(delay);<br></td></tr
><tr
id=sl_svn4_304

><td class="source">		fadeOut.setDuration(duration);<br></td></tr
><tr
id=sl_svn4_305

><td class="source"><br></td></tr
><tr
id=sl_svn4_306

><td class="source">		return fadeOut;<br></td></tr
><tr
id=sl_svn4_307

><td class="source">	} <br></td></tr
><tr
id=sl_svn4_308

><td class="source"><br></td></tr
><tr
id=sl_svn4_309

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_310

><td class="source">	 * A fade animation that will ensure the View starts and ends with the correct visibility<br></td></tr
><tr
id=sl_svn4_311

><td class="source">	 * @param view the View to be faded in<br></td></tr
><tr
id=sl_svn4_312

><td class="source">	 * @param duration the animation duration in milliseconds<br></td></tr
><tr
id=sl_svn4_313

><td class="source">	 * @return a fade animation that will set the visibility of the view at the start and end of animation<br></td></tr
><tr
id=sl_svn4_314

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_315

><td class="source">	public static Animation fadeInAnimation(long duration, final View view) { <br></td></tr
><tr
id=sl_svn4_316

><td class="source">		Animation animation = fadeInAnimation(500, 0); <br></td></tr
><tr
id=sl_svn4_317

><td class="source"><br></td></tr
><tr
id=sl_svn4_318

><td class="source">	    animation.setAnimationListener(new AnimationListener() { <br></td></tr
><tr
id=sl_svn4_319

><td class="source">			@Override<br></td></tr
><tr
id=sl_svn4_320

><td class="source">			public void onAnimationEnd(Animation animation) {<br></td></tr
><tr
id=sl_svn4_321

><td class="source">				view.setVisibility(View.VISIBLE);<br></td></tr
><tr
id=sl_svn4_322

><td class="source">			} <br></td></tr
><tr
id=sl_svn4_323

><td class="source">			<br></td></tr
><tr
id=sl_svn4_324

><td class="source">			@Override<br></td></tr
><tr
id=sl_svn4_325

><td class="source">			public void onAnimationRepeat(Animation animation) { <br></td></tr
><tr
id=sl_svn4_326

><td class="source">			}  <br></td></tr
><tr
id=sl_svn4_327

><td class="source">			<br></td></tr
><tr
id=sl_svn4_328

><td class="source">			@Override<br></td></tr
><tr
id=sl_svn4_329

><td class="source">			public void onAnimationStart(Animation animation) {<br></td></tr
><tr
id=sl_svn4_330

><td class="source">				view.setVisibility(View.GONE); <br></td></tr
><tr
id=sl_svn4_331

><td class="source">			} <br></td></tr
><tr
id=sl_svn4_332

><td class="source">	    });<br></td></tr
><tr
id=sl_svn4_333

><td class="source">	    <br></td></tr
><tr
id=sl_svn4_334

><td class="source">	    return animation;<br></td></tr
><tr
id=sl_svn4_335

><td class="source">	}<br></td></tr
><tr
id=sl_svn4_336

><td class="source"><br></td></tr
><tr
id=sl_svn4_337

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_338

><td class="source">	 * A fade animation that will ensure the View starts and ends with the correct visibility<br></td></tr
><tr
id=sl_svn4_339

><td class="source">	 * @param view the View to be faded out<br></td></tr
><tr
id=sl_svn4_340

><td class="source">	 * @param duration the animation duration in milliseconds<br></td></tr
><tr
id=sl_svn4_341

><td class="source">	 * @return a fade animation that will set the visibility of the view at the start and end of animation<br></td></tr
><tr
id=sl_svn4_342

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_343

><td class="source">	public static Animation fadeOutAnimation(long duration, final View view) {<br></td></tr
><tr
id=sl_svn4_344

><td class="source">		<br></td></tr
><tr
id=sl_svn4_345

><td class="source">		Animation animation = fadeOutAnimation(500, 0); <br></td></tr
><tr
id=sl_svn4_346

><td class="source"><br></td></tr
><tr
id=sl_svn4_347

><td class="source">	    animation.setAnimationListener(new AnimationListener() { <br></td></tr
><tr
id=sl_svn4_348

><td class="source">			@Override<br></td></tr
><tr
id=sl_svn4_349

><td class="source">			public void onAnimationEnd(Animation animation) {<br></td></tr
><tr
id=sl_svn4_350

><td class="source">				view.setVisibility(View.GONE);<br></td></tr
><tr
id=sl_svn4_351

><td class="source">			} <br></td></tr
><tr
id=sl_svn4_352

><td class="source">			<br></td></tr
><tr
id=sl_svn4_353

><td class="source">			@Override<br></td></tr
><tr
id=sl_svn4_354

><td class="source">			public void onAnimationRepeat(Animation animation) { <br></td></tr
><tr
id=sl_svn4_355

><td class="source">			}  <br></td></tr
><tr
id=sl_svn4_356

><td class="source">			<br></td></tr
><tr
id=sl_svn4_357

><td class="source">			@Override<br></td></tr
><tr
id=sl_svn4_358

><td class="source">			public void onAnimationStart(Animation animation) {<br></td></tr
><tr
id=sl_svn4_359

><td class="source">				view.setVisibility(View.VISIBLE); <br></td></tr
><tr
id=sl_svn4_360

><td class="source">			} <br></td></tr
><tr
id=sl_svn4_361

><td class="source">	    });<br></td></tr
><tr
id=sl_svn4_362

><td class="source">	    <br></td></tr
><tr
id=sl_svn4_363

><td class="source">	    return animation;<br></td></tr
><tr
id=sl_svn4_364

><td class="source">		<br></td></tr
><tr
id=sl_svn4_365

><td class="source">	}<br></td></tr
><tr
id=sl_svn4_366

><td class="source"><br></td></tr
><tr
id=sl_svn4_367

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_368

><td class="source">	 * Creates a pair of animation that will fade in, delay, then fade out<br></td></tr
><tr
id=sl_svn4_369

><td class="source">	 * @param duration the animation duration in milliseconds<br></td></tr
><tr
id=sl_svn4_370

><td class="source">	 * @param delay how long to wait after fading in the subject and before starting the fade out<br></td></tr
><tr
id=sl_svn4_371

><td class="source">	 * @return a fade in then out animations<br></td></tr
><tr
id=sl_svn4_372

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_373

><td class="source">	public static Animation[] fadeInThenOutAnimation(long duration, long delay) {  <br></td></tr
><tr
id=sl_svn4_374

><td class="source">		return new Animation[] {fadeInAnimation(duration,0), fadeOutAnimation(duration, duration+delay)};<br></td></tr
><tr
id=sl_svn4_375

><td class="source">	}  <br></td></tr
><tr
id=sl_svn4_376

><td class="source">	<br></td></tr
><tr
id=sl_svn4_377

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_378

><td class="source">	 * Fades the view in. Animation starts right away.<br></td></tr
><tr
id=sl_svn4_379

><td class="source">	 * @param v the view to be faded in<br></td></tr
><tr
id=sl_svn4_380

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_381

><td class="source">	public static void fadeOut(View v) { <br></td></tr
><tr
id=sl_svn4_382

><td class="source">		if (v==null) return;  <br></td></tr
><tr
id=sl_svn4_383

><td class="source">	    v.startAnimation(fadeOutAnimation(500, v)); <br></td></tr
><tr
id=sl_svn4_384

><td class="source">	} <br></td></tr
><tr
id=sl_svn4_385

><td class="source">	<br></td></tr
><tr
id=sl_svn4_386

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_387

><td class="source">	 * Fades the view out. Animation starts right away.<br></td></tr
><tr
id=sl_svn4_388

><td class="source">	 * @param v the view to be faded out<br></td></tr
><tr
id=sl_svn4_389

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_390

><td class="source">	public static void fadeIn(View v) { <br></td></tr
><tr
id=sl_svn4_391

><td class="source">		if (v==null) return;<br></td></tr
><tr
id=sl_svn4_392

><td class="source">		<br></td></tr
><tr
id=sl_svn4_393

><td class="source">	    v.startAnimation(fadeInAnimation(500, v)); <br></td></tr
><tr
id=sl_svn4_394

><td class="source">	}<br></td></tr
><tr
id=sl_svn4_395

><td class="source">	<br></td></tr
><tr
id=sl_svn4_396

><td class="source">	/**<br></td></tr
><tr
id=sl_svn4_397

><td class="source">	 * Fades the view in, delays the specified amount of time, then fades the view out<br></td></tr
><tr
id=sl_svn4_398

><td class="source">	 * @param v the view to be faded in then out<br></td></tr
><tr
id=sl_svn4_399

><td class="source">	 * @param delay how long the view will be visible for<br></td></tr
><tr
id=sl_svn4_400

><td class="source">	 */<br></td></tr
><tr
id=sl_svn4_401

><td class="source">	public static void fadeInThenOut(final View v, long delay) {<br></td></tr
><tr
id=sl_svn4_402

><td class="source">		if (v==null) return;<br></td></tr
><tr
id=sl_svn4_403

><td class="source">		 <br></td></tr
><tr
id=sl_svn4_404

><td class="source">		v.setVisibility(View.VISIBLE);<br></td></tr
><tr
id=sl_svn4_405

><td class="source">		AnimationSet animation = new AnimationSet(true);<br></td></tr
><tr
id=sl_svn4_406

><td class="source">		Animation[] fadeInOut = fadeInThenOutAnimation(500,delay); <br></td></tr
><tr
id=sl_svn4_407

><td class="source">	    animation.addAnimation(fadeInOut[0]);<br></td></tr
><tr
id=sl_svn4_408

><td class="source">	    animation.addAnimation(fadeInOut[1]);<br></td></tr
><tr
id=sl_svn4_409

><td class="source">	    animation.setAnimationListener(new AnimationListener() { <br></td></tr
><tr
id=sl_svn4_410

><td class="source">			@Override<br></td></tr
><tr
id=sl_svn4_411

><td class="source">			public void onAnimationEnd(Animation animation) {<br></td></tr
><tr
id=sl_svn4_412

><td class="source">				v.setVisibility(View.GONE);<br></td></tr
><tr
id=sl_svn4_413

><td class="source">			} <br></td></tr
><tr
id=sl_svn4_414

><td class="source">			@Override<br></td></tr
><tr
id=sl_svn4_415

><td class="source">			public void onAnimationRepeat(Animation animation) { <br></td></tr
><tr
id=sl_svn4_416

><td class="source">			}  <br></td></tr
><tr
id=sl_svn4_417

><td class="source">			@Override<br></td></tr
><tr
id=sl_svn4_418

><td class="source">			public void onAnimationStart(Animation animation) {<br></td></tr
><tr
id=sl_svn4_419

><td class="source">				v.setVisibility(View.VISIBLE); <br></td></tr
><tr
id=sl_svn4_420

><td class="source">			} <br></td></tr
><tr
id=sl_svn4_421

><td class="source">	    });<br></td></tr
><tr
id=sl_svn4_422

><td class="source">	    <br></td></tr
><tr
id=sl_svn4_423

><td class="source">	    v.startAnimation(animation); <br></td></tr
><tr
id=sl_svn4_424

><td class="source">	}<br></td></tr
><tr
id=sl_svn4_425

><td class="source"><br></td></tr
><tr
id=sl_svn4_426

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
 <a href="/p/android-3d-flip-view-transition/source/detail?spec=svn4&amp;r=4">r4</a>
 by genzeb
 on Mar 26, 2012
 &nbsp; <a href="/p/android-3d-flip-view-transition/source/diff?spec=svn4&r=4&amp;format=side&amp;path=/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java&amp;old_path=/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java&amp;old=2">Diff</a>
 </div>
 <pre>Fixed focus issue after the first full
flip transition is over (touch wasn't
being traversed to the hidden view and its
subviews after it has flipped into being
front).</pre>
 </div>
 
 
 
 
 
 
 <script type="text/javascript">
 var detail_url = '/p/android-3d-flip-view-transition/source/detail?r=4&spec=svn4';
 var publish_url = '/p/android-3d-flip-view-transition/source/detail?r=4&spec=svn4#publish';
 // describe the paths of this revision in javascript.
 var changed_paths = [];
 var changed_urls = [];
 
 changed_paths.push('/trunk/AndroidManifest.xml');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/AndroidManifest.xml?r\x3d4\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/res/layout/main.xml');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/res/layout/main.xml?r\x3d4\x26spec\x3dsvn4');
 
 
 changed_paths.push('/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java?r\x3d4\x26spec\x3dsvn4');
 
 var selected_path = '/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java';
 
 
 changed_paths.push('/trunk/src/flipviewtransition/Flip3DViewTransitionActivity.java');
 changed_urls.push('/p/android-3d-flip-view-transition/source/browse/trunk/src/flipviewtransition/Flip3DViewTransitionActivity.java?r\x3d4\x26spec\x3dsvn4');
 
 
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
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/AndroidManifest.xml?r=4&amp;spec=svn4"
 
 >/trunk/AndroidManifest.xml</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/res/layout/main.xml?r=4&amp;spec=svn4"
 
 >/trunk/res/layout/main.xml</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java?r=4&amp;spec=svn4"
 selected="selected"
 >.../animation/AnimationFactory.java</option>
 
 <option value="/p/android-3d-flip-view-transition/source/browse/trunk/src/flipviewtransition/Flip3DViewTransitionActivity.java?r=4&amp;spec=svn4"
 
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
 
 
 <div class="closed" style="margin-bottom:3px;" >
 <a class="ifClosed" onclick="return _toggleHidden(this)"><img src="https://ssl.gstatic.com/codesite/ph/images/plus.gif" ></a>
 <a class="ifOpened" onclick="return _toggleHidden(this)"><img src="https://ssl.gstatic.com/codesite/ph/images/minus.gif" ></a>
 <a href="/p/android-3d-flip-view-transition/source/detail?spec=svn4&r=2">r2</a>
 by genzeb
 on Jan 30, 2012
 &nbsp; <a href="/p/android-3d-flip-view-transition/source/diff?spec=svn4&r=2&amp;format=side&amp;path=/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java&amp;old_path=/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java&amp;old=">Diff</a>
 <br>
 <pre class="ifOpened">First commit to depot.</pre>
 </div>
 
 
 <a href="/p/android-3d-flip-view-transition/source/list?path=/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java&start=4">All revisions of this file</a>
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
 
 <div>Size: 15301 bytes,
 426 lines</div>
 
 <div><a href="//android-3d-flip-view-transition.googlecode.com/svn/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java">View raw file</a></div>
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
 var paths = {'svn4': '/trunk/src/com/tekle/oss/android/animation/AnimationFactory.java'}
 codereviews = CR_controller.setup(
 {"loggedInUserEmail": "potatothezero@gmail.com", "relativeBaseUrl": "", "projectHomeUrl": "/p/android-3d-flip-view-transition", "projectName": "android-3d-flip-view-transition", "assetVersionPath": "https://ssl.gstatic.com/codesite/ph/8599073060794244502", "domainName": null, "assetHostPath": "https://ssl.gstatic.com/codesite/ph", "token": "ABZ6GAebXUX0Y9OXMwWbdjoU8mAltkdmcg:1434264984218", "profileUrl": "/u/107328840504307469604/"}, '', 'svn4', paths,
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

