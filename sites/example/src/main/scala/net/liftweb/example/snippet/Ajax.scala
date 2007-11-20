package net.liftweb.example.snippet

/*                                                *\
 (c) 2007 WorldWide Conferencing, LLC
 Distributed under an Apache License
 http://www.apache.org/licenses/LICENSE-2.0
 \*                                                 */

import net.liftweb.http._
import S._
import js._
import JsCmds._
import net.liftweb.util._
import Helpers._
import scala.xml. _

class Ajax {

  def sample = {
    var cnt = 0

    <span>
    {
      a(() => {cnt = cnt + 1; Set("cnt_id", Text( cnt.toString))}, <span>Click me to increase the count (currently <span id='cnt_id'>0</span>)</span>) // a link that does AJAX to increment a counter server-side and displays the result on the client
    } <br />

    <div id="messages"></div>
    {
      val opts = (1 to 50).toList.map(i => (i.toString, i.toString)) // build the options
      ajaxSelect(opts, Full(1.toString), v => DisplayMessage("messages", Text("You selected "+v), 5 seconds, 1 second))
    } <br />
    {
      ajaxText("", v => DisplayMessage("messages", Text("You entered some text: "+v), 4 seconds, 1 second))
    } <br />
    {
      swappable(<span>Click to edit: <span id='the_text'></span></span>,
		ajaxText("", v => DisplayMessage("messages", Text("You entered some text: "+v), 4 seconds, 1 second) + Set("the_text", Text(v))))
    } <br />

    <textarea id="the_area" cols="50" rows="10"></textarea>
    <br />

    <a href="#" onclick={ajaxCall("document.getElementById('the_area').value",
				  text => DisplayMessage("messages", <pre>{text}</pre>, 4 seconds, 200))}>Enter text above and click me</a>


    </span>
  }
}
