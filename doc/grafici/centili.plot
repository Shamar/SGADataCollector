set terminal postscript eps enhanced color size 5, 5
set output 'grafici/centili/centili.eps'
set multiplot layout 2, 2
unset key #set key outside top right
#set xlabel "Settimane"
#set size square
set ylabel "Peso (kg)"
set yrange [0.5:5.0]
set xtics 2
set grid
set title "Femmine"
plot 	"grafici/centili/peso.f03.dat" using 1:2 with lines lt -1 lc 1 ti "3°",\
	"grafici/centili/peso.f10.dat" using 1:2 with lines lt  3 lc 1 ti "10°",\
	"grafici/centili/peso.f25.dat" using 1:2 with lines lt  3 lc 1 ti "25°",\
	"grafici/centili/peso.f50.dat" using 1:2 with lines lt -1 lc 1 ti "50°",\
	"grafici/centili/peso.f75.dat" using 1:2 with lines lt  3 lc 1 ti "75°",\
	"grafici/centili/peso.f90.dat" using 1:2 with lines lt  3 lc 1 ti "90°",\
	"grafici/centili/peso.f97.dat" using 1:2 with lines lt -1 lc 1 ti "97°" 
set title "Maschi"
plot 	"grafici/centili/peso.m03.dat" using 1:2 with lines lt -1 lc 3 ti "3°",\
	"grafici/centili/peso.m10.dat" using 1:2 with lines lt  3 lc 3 ti "10°",\
	"grafici/centili/peso.m25.dat" using 1:2 with lines lt  3 lc 3 ti "25°",\
	"grafici/centili/peso.m50.dat" using 1:2 with lines lt -1 lc 3 ti "50°",\
	"grafici/centili/peso.m75.dat" using 1:2 with lines lt  3 lc 3 ti "75°",\
	"grafici/centili/peso.m90.dat" using 1:2 with lines lt  3 lc 3 ti "90°",\
	"grafici/centili/peso.m97.dat" using 1:2 with lines lt -1 lc 3 ti "97°" 
unset key #set key outside top right
set xlabel "Settimane"
set ylabel "Altezza (cm)"
set yrange [25:60]
set xtics 2
set grid
#set title "Femmine"
unset title
plot 	"grafici/centili/altezza.f03.dat" using 1:2 with lines lt -1 lc 1 ti "3°",\
	"grafici/centili/altezza.f10.dat" using 1:2 with lines lt  3 lc 1 ti "10°",\
	"grafici/centili/altezza.f25.dat" using 1:2 with lines lt  3 lc 1 ti "25°",\
	"grafici/centili/altezza.f50.dat" using 1:2 with lines lt -1 lc 1 ti "50°",\
	"grafici/centili/altezza.f75.dat" using 1:2 with lines lt  3 lc 1 ti "75°",\
	"grafici/centili/altezza.f90.dat" using 1:2 with lines lt  3 lc 1 ti "90°",\
	"grafici/centili/altezza.f97.dat" using 1:2 with lines lt -1 lc 1 ti "97°" 
#set title "Maschi"                                           
plot 	"grafici/centili/altezza.m03.dat" using 1:2 with lines lt -1 lc 3 ti "3°",\
	"grafici/centili/altezza.m10.dat" using 1:2 with lines lt  3 lc 3 ti "10°",\
	"grafici/centili/altezza.m25.dat" using 1:2 with lines lt  3 lc 3 ti "25°",\
	"grafici/centili/altezza.m50.dat" using 1:2 with lines lt -1 lc 3 ti "50°",\
	"grafici/centili/altezza.m75.dat" using 1:2 with lines lt  3 lc 3 ti "75°",\
	"grafici/centili/altezza.m90.dat" using 1:2 with lines lt  3 lc 3 ti "90°",\
	"grafici/centili/altezza.m97.dat" using 1:2 with lines lt -1 lc 3 ti "97°" 
