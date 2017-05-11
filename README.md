# Seckill
use SSM for Seckill web


1.进入项目所在文件夹
2.git init//把这个目录变成git可以管理的仓库
3.git add .//将所有文件添加到仓库
4.git commit -m "提交文件"//这样本地仓库就建好了
5.关联github：
git remote rm origin
git remote add origin git@github.com:datouerhao/Seckill.git
6.上传本地代码
git push -u origin master
如果报错输入：
git pull --rebase origin master//将github中的REDME.md文件合并到本地文件夹
然后再输入上面上传指令，则上传成功。






