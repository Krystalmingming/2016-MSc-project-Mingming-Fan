predictor <- read.table("~/Documents/MSc project/data analysis/predictor.csv", quote="\"", comment.char="")
response <- read.table("~/Documents/MSc project/data analysis/response.csv", quote="\"", comment.char="")

library(CausalImpact)

y<-response$V1
x1<-predictor$V1

post.period <- c(123, 264)
post.period.response <- y[post.period[1] : post.period[2]]
y[post.period[1] : post.period[2]] <- NA

#set up and estimate a time-series model using the bsts package
ss <- AddLocalLevel(list(), y)
bsts.model <- bsts(y ~ x1, ss, niter = 5000)

impact <- CausalImpact(bsts.model = bsts.model,
                       post.period.response = post.period.response)

#------added code-------#

#plot(impact, c("cumulative"))
#plot(impact,c("original"))
#plot(impact,c("pointwise"))
plot(impact)
summary(impact)
#summary(impact, "report")
impact$series
write(impact$series, file = "data.txt", append = FALSE, sep = " ")
#impact$model