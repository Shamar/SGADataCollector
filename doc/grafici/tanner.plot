set terminal postscript eps enhanced color #size 15, 20
set output 'grafici/tanner/growthOUT.eps'
set xtics 1
set ytics 10
set mytics 10
set mxtics 10 
#set grid xtics ytics mxtics mytics # millimeters
set xrange [0:19]
set yrange [60:190]
set nokey
set xlabel "Age, years"
set ylabel "Height, cm"

# Functions
sigma(mu,nintyPercentile)=(nintyPercentile - mu) / 1.2815515641
heightAt(zScore,mu,nintyPercentile)=mu + (sigma(mu,nintyPercentile)*zScore)
heightAt3(mu,ninty)=heightAt(-1.880793606, mu, ninty)
heightAt10(mu,ninty)=heightAt(-1.2815515641, mu, ninty)
heightAt25(mu,ninty)=heightAt(-0.6744897502, mu, ninty)
heightAt50(mu,ninty)=mu
heightAt75(mu,ninty)=heightAt(0.6744897502, mu, ninty)
heightAt90(mu,ninty)=ninty
heightAt97(mu,ninty)=heightAt(1.880793606, mu, ninty)

plot    "grafici/tanner/standardM.dat" using 1:(heightAt90($2,$3)) smooth csplines with lines lt -1 lc 1 ti "90°",\
	"grafici/tanner/standardM.dat" using 1:(heightAt50($2,$3)) smooth csplines with lines lt -1 lc 1 ti "50°",\
	"grafici/tanner/standardM.dat" using 1:(heightAt3($2,$3)) smooth csplines with lines lt 2 lc 1 ti "3°",\
	"grafici/tanner/standardM.dat" using 1:(heightAt10($2,$3)) smooth csplines with lines lt -1 lc 1 ti "10°",\
	"grafici/tanner/standardM.dat" using 1:(heightAt25($2,$3)) smooth csplines with lines lt 2 lc 1 ti "25°",\
	"grafici/tanner/standardM.dat" using 1:(heightAt75($2,$3)) smooth csplines with lines lt 2 lc 1 ti "75°",\
	"grafici/tanner/standardM.dat" using 1:(heightAt97($2,$3)) smooth csplines with lines lt 2 lc 1 ti "97°"
