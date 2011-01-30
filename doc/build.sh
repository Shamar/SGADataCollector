#!/bin/bash
cd ~/SGA/SGADataCollector/doc/
export LOG=$(zenity --entry --text "Cosa hai fatto?")
if [ ! -n "$LOG" ]; then
  export LOG="piccole correzioni"
fi

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
  (git commit -am "$LOG")
#  (git push origin master)
  showPDF Tesi.pdf
else
  zenity --error --text "Errore: chiedi a Giacomo" #&& false
fi
