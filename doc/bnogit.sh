#!/bin/bash -eu

plot()
{
        if command -v gnuplot &>/dev/null
        then
                gnuplot $1
                return 1
        fi
}

showPDF()
{
        if command -v xpdf &>/dev/null
        then
                xpdf $1
               return 1
	else
		/c/Programmi/Adobe/Reader\ 9.0/Reader/AcroRd32.exe 'C:\Documents and Settings\Sara\SGA\SGADataCollector\doc\Tesi.pdf'
		return 1
        fi
}

cd ~/SGA/SGADataCollector/doc/
#gnuplot grafici/centili.plot
plot grafici/centili.plot

(pdflatex -interaction nonstopmode tesi_sara.tex)
(bibtex tesi_sara)
(pdflatex -interaction nonstopmode tesi_sara.tex)
(pdflatex -interaction nonstopmode tesi_sara.tex)
(pdflatex -interaction nonstopmode tesi_sara.tex)
(thumbpdf tesi_sara.pdf)
(pdflatex -interaction nonstopmode --shell-escape tesi_sara.tex)

if [ -f tesi_sara.pdf ]; then
  (rm *.aux *.lo* *.toc *.tpt *.bbl *.blg)
  (mv tesi_sara.pdf Tesi.pdf)
  (cd ../)
  showPDF Tesi.pdf
else
  zenity --error --text "Errore: chiedi a Giacomo" #&& false
fi
