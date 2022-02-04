# algorithms


<div class="brinza-task-description">
<p>There is a forum that has a limit of K characters per entry. In this task your job is to implement an algorithm for cropping messages that are too long. You are given a message, consisting of English alphabet letters and spaces, that might be longer than the limit. Your algorithm should crop a number of words from the end of the message, keeping in mind that:</p>
<blockquote><ul style="margin: 10px;padding: 0px;"><li>it may not crop away part of a word;</li>
<li>the output message may not end with a space;</li>
<li>the output message may not exceed the K-character limit;</li>
<li>the output message should be as long as possible.</li>
</ul>
</blockquote><p>This means that, in some cases, the algorithm may need to crop away the entire message, outputting an empty string.</p>
<p>For example, given the text:</p>
<p>"<tt style="white-space:pre-wrap">Codility We test coders</tt>"</p>
<p>With K = 14 the algorithm should output:</p>
<p>"<tt style="white-space:pre-wrap">Codility We</tt>"</p>
<p>Note that:</p>
<blockquote><ul style="margin: 10px;padding: 0px;"><li>the output "<tt style="white-space:pre-wrap">Codility We te</tt>" would be incorrect, because the original message is cropped through the middle of a word;</li>
<li>the output "<tt style="white-space:pre-wrap">Codility We </tt>" would be incorrect, because it ends with a space;</li>
<li>the output "<tt style="white-space:pre-wrap">Codility We test coders</tt>" would be incorrect, because it exceeds the K-character limit;</li>
<li>the output "<tt style="white-space:pre-wrap">Codility</tt>" would be incorrect, because it is shorter than the correct output.</li>
</ul>
</blockquote><p>Write a function</p>
<blockquote><p style="font-family: monospace; font-size: 9pt; display: block; white-space: pre-wrap"><tt>class Solution { public String solution(String message, int K); }</tt></p></blockquote>
<p>which, given a message and an integer K, returns the message cropped to no more than K characters, as described above.</p>
<p><b>Examples:</b></p>
<p>1. Given message = "<tt style="white-space:pre-wrap">Codility We test coders</tt>" and K = 14, the function should return "<tt style="white-space:pre-wrap">Codility We</tt>".</p>
<p>2. Given message = "<tt style="white-space:pre-wrap">Why not</tt>" and K = 100, the function should return "<tt style="white-space:pre-wrap">Why not</tt>".</p>
<p>3. Given message = "<tt style="white-space:pre-wrap">The quick brown fox jumps over the lazy dog</tt>" and K = 39, the function should return "<tt style="white-space:pre-wrap">The quick brown fox jumps over the lazy</tt>".</p>
<p>4. Given message = "<tt style="white-space:pre-wrap">To crop or not to crop</tt>" and K = 21, the function should return "<tt style="white-space:pre-wrap">To crop or not to</tt>".</p>
<p>Assume that:</p>
<blockquote><ul style="margin: 10px;padding: 0px;"><li>K is an integer within the range [<span class="number">1</span>..<span class="number">500</span>];</li>
<li><tt style="white-space:pre-wrap">message</tt> is a non-empty string containing at most 500 English alphabet letters and spaces. There are no spaces at the beginning or at the end of <tt style="white-space:pre-wrap">message</tt>; also there can't be two or more consecutive spaces in <tt style="white-space:pre-wrap">message</tt>.</li>
</ul>
</blockquote><p>In your solution, focus on <b><b>correctness</b></b>. The performance of your solution will not be the focus of the assessment.</p>
</div>
