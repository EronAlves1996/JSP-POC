# JSP componentization POC

What's possible to do with just SSR? I think that most things actual Javascript frameworks can do, SSR can achieve too!

## Objective

This POC aims to implement and present POC of most, or all, features that Front-End frameworks do, using just Java servlets and a single JSP page, just like a SPA, generating dynamic view without refreshing the page. The hability to refresh, also, cannot be nullified, because all the processing gonna ocurr in the server, but, implementing this in the server can save good amounts in memory in the client side, and get better results in SEO and rendering performance. 

Everything has tradeoffs, and the SEO and client rendering performance comes with a cost of processing in the server side.

## The stack

* Only one JSP page;
* Servlets;
* It was preferred Tomcat Server container, version 9. It uses javax.servlet API. For something more Jakarta compliant, needs some rewriting/adaptations;

## Concepts

The concepts to be proved was all in the issues section. If you wanna something to be proved, please, open a issue! 