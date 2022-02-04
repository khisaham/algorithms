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






<div class="brinza-task-description">
<p>An industrial company has N factories, each producing some pollution every month. The company has decided to reduce its total fume emissions by equipping some of the factories with one or more filters.</p>
<p>Every such filter reduces the pollution of a factory by half. When a second (or subsequent) filter is applied, it again reduces by half the remaining pollution emitted after fitting the existing filter(s). For example, a factory that initially produces 6 units of pollution will generate 3 units with one filter, 1.5 units with two filters and 0.75 units with three filters.</p>
<p>You are given an array of N integers describing the amount of pollution produced by the factories. Your task is to find the minimum number of filters needed to decrease the total sum of pollution by at least half.</p>
<p>Write a function:</p>
<blockquote><p style="font-family: monospace; font-size: 9pt; display: block; white-space: pre-wrap"><tt>class Solution { public int solution(int[] A); }</tt></p></blockquote>
<p>which, given an array of integers A of length N, returns the minimum number of filters needed to reduce the total pollution by at least half.</p>
<p><b>Examples:</b></p>
<p>1. Given A = [5, 19, 8, 1], your function should return 3. The initial total pollution is 5 + 19 + 8 + 1 = 33. We install two filters at the factory producing 19 units and one filter at the factory producing 8 units. Then the total pollution will be 5 + ((19 / 2) / 2) + (8 / 2) + 1 = 5 + 4.75 + 4 + 1 = 14.75 which is less than 33 / 2 = 16.5, so we have achieved our goal.</p>
<p>2. Given A = [10, 10], your function should return 2, because we may install one filter at each factory.</p>
<p>3. Given A = [3, 0, 5], your function should return 2, because it is sufficient to install one filter at each factory producing a non-zero amount of pollution.</p>
<p>Write an <b><b>efficient</b></b> algorithm for the following assumptions:</p>
<blockquote><ul style="margin: 10px;padding: 0px;"><li>N is an integer within the range [<span class="number">1</span>..<span class="number">30,000</span>];</li>
<li>each element of array A is an integer within the range [<span class="number">0</span>..<span class="number">70,000</span>].</li>
</ul>
</blockquote>
</div>



<div class="brinza-task-description">
<p>A group of friends is going on holiday together. They have come to a meeting point (the start of the journey) using N cars. There are P[K] people and S[K] seats in the K-th car for K in range [0..N-1]. Some of the seats in the cars may be free, so it is possible for some of the friends to change the car they are in. The friends have decided that, in order to be ecological, they will leave some cars parked at the meeting point and travel with as few cars as possible.</p>
<p>Write a function:</p>
<blockquote><p style="font-family: monospace; font-size: 9pt; display: block; white-space: pre-wrap"><tt>class Solution { public int solution(int[] P, int[] S); }</tt></p></blockquote>
<p>that, given two arrays P and S, consisting of N integers each, returns the minimum number of cars needed to take all of the friends on holiday.</p>
<p><b>Examples:</b></p>
<p>1. Given P = [1, 4, 1] and S = [1, 5, 1], the function should return 2. A person from car number 0 can travel in car number 1 instead. This way, car number 0 can be left parked at the meeting point.</p>
<p>2. Given P = [4, 4, 2, 4] and S = [5, 5, 2, 5], the function should return 3. One person from car number 2 can travel in car number 0 and the other person from car number 2 can travel in car number 3.</p>
<p>3. Given P = [2, 3, 4, 2] and S = [2, 5, 7, 2], the function should return 2. Passengers from car number 0 can travel in car number 1 and passengers from car number 3 can travel in car number 2.</p>
<p>Write an <b><b>efficient</b></b> algorithm for the following assumptions:</p>
<blockquote><ul style="margin: 10px;padding: 0px;"><li>N is an integer within the range [<span class="number">1</span>..<span class="number">100,000</span>];</li>
<li>each element of arrays P and S is an integer within the range [<span class="number">1</span>..<span class="number">9</span>];</li>
<li>every friend had a seat in the car they came in; that is, P[K] ≤ S[K] for each K within the range [0..N-1].</li>
</ul>
</blockquote>
</div>
