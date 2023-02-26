import React from "react";

const Bloquetres = () => {
  return <div className="mx-5 gap-8 grid grid-cols-1 md:grid-cols-3 md:mx-4 lg:mx-6 2xl:mx-20">
    <div className="flex flex-row">
    <div className="w-[200px] sm:w-[360px] 2xl:w-[226px]">
        <a className="category font-crimson font-semibold text-sm xl:text-base text-[#2c9995]" href="">Category</a>
        <h2 className="font-poppins font-semibold text-base md:text-sm xl:text-base">Titulo bloque 3 fsdf</h2>
        <p className="font-crimson font-normal text-sm text-gray-400 xl:text-base pt-1">Hora de publicación</p>
    </div>
    <div className="w-[160px] sm:w-[240px] 2xl:w-[200px]">
        <img className=" " src="../public/pt2-1.jpg" alt="" />
    </div>
    </div>
    <div className="flex flex-row">
    <div className="w-[200px] sm:w-[360px] 2xl:w-[226px]">
        <a className="category font-crimson font-semibold text-sm xl:text-base text-[#2c9995]" href="">Category</a>
        <h2 className="font-poppins font-semibold text-base md:text-sm xl:text-base">Titulo bloque 3333</h2>
        <p className="font-crimson font-normal text-sm text-gray-400 xl:text-base pt-1">Hora de publicación</p>
    </div>
    <div className="w-[160px] sm:w-[240px] 2xl:w-[200px]">
        <img className="h-[112px] sm:h-[192px] md:h-[70px] xl:h-[132px] objet-cover w-full" src="../public/pt2-2.jpg" alt="" />
    </div>
    </div>
    <div className="flex flex-row">
    <div className="w-[200px] sm:w-[360px] 2xl:w-[226px]">
        <a className="category font-crimson font-semibold text-sm xl:text-base text-[#2c9995]" href="">Category</a>
        <h2 className="font-poppins font-semibold text-base md:text-sm xl:text-base">Titulo bloque 3 df</h2>
        <p className="font-crimson font-normal text-sm text-gray-400 pt-1 xl:text-base">Hora de publicación</p>
    </div>
    <div className="w-[160px] sm:w-[240px] 2xl:w-[200px]">
        <img className="h-[112px] sm:h-[192px] md:h-[70px] xl:h-[132px] objet-cover w-full" src="../public/pt2-5.jpg" alt="" />
    </div>
    </div>
  </div>;
};

export default Bloquetres;
