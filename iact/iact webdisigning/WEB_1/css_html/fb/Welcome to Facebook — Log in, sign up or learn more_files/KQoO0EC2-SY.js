/*!CK:408067822!*//*1431966190,*/

if (self.CavalryLogger) { CavalryLogger.start_js(["2pYkj"]); }

__d("WebStorage",["ErrorUtils","ex"],function(a,b,c,d,e,f,g,h){b.__markCompiled&&b.__markCompiled();var i={};function j(q){if(!i.hasOwnProperty(q))i[q]=k(q);return i[q];}function k(q){try{var s=window[q];if(s){var t='__test__'+Date.now();s.setItem(t,'');s.removeItem(t);}return s;}catch(r){}}function l(){return j('localStorage');}function m(){return j('sessionStorage');}function n(q){var r=[];for(var s=0;s<q.length;s++)r.push(q.key(s));return r;}function o(q,r,s){var t=null;try{q.setItem(r,s);}catch(u){var v=n(q).map(function(w){var x=q.getItem(w).length;return w+'('+x+')';});t=new Error(h('Storage quota exceeded while setting %s(%s). Items(length) follows: %s',r,s.length,v.join()));g.reportError(t);}return t;}var p={getLocalStorage:l,getSessionStorage:m,setItemGuarded:o};e.exports=p;},null);