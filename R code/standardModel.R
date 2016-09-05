predictor <- read.table("~/Documents/MSc project/data analysis/predictor.csv", quote="\"", comment.char="")
response <- read.table("~/Documents/MSc project/data analysis/response.csv", quote="\"", comment.char="")
library(CausalImpact)

y<-response
x1<-predictor
#colnames(data) <- c("y","x1") #y is the resonse, which is the treatment data, x1 is the predictor, which is the control data
time.points <- seq.Date(as.Date("2015-04-01"), by = 1, length.out = 264)
data <- zoo(cbind(y, x1), time.points)
colnames(data) <- c("y","x1")
pre.period <- as.Date(c("2015-04-01", "2015-07-31"))
post.period <- as.Date(c("2015-08-01", "2015-12-20"))
impact <- CausalImpact(data, pre.period, post.period, model.args = list(niter = 5000,nseasons = 7))
#plot(impact)
#plot(impact, c("cumulative"))
plot(impact,c("original"))
#plot(impact,c("pointwise"))
summary(impact)
summary(impact, "report")
#impact$series
